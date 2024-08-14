package com.ce.fisa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.controller.PartnerController;
import com.ce.fisa.dao.CommentRepository;
import com.ce.fisa.dao.InquiryRepository;
import com.ce.fisa.dao.UserRepository;
import com.ce.fisa.dao.WorkRepository;
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.AllInquiryDTO;
import com.ce.fisa.model.dto.CommentDTO;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.entity.Comment;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.model.entity.User;
import com.ce.fisa.model.entity.Work;

import jakarta.servlet.http.HttpSession;

@Service
public class InquiryServiceImpl implements InquiryService {
	
	private static final Logger logger = LogManager.getLogger(PartnerController.class);
	
	@Autowired
	private InquiryRepository inquiryDAO;
	
	@Autowired
	private CommentRepository commentDAO;
	
	@Autowired
	private UserRepository userDAO;

	@Autowired
	private WorkRepository workDAO;
	
	@Autowired
	private HttpSession httpSession;
	
	// DTO <-> Entity
	private ModelMapper mapper = new ModelMapper();
	
	// Entity to DTO conversion
	private InquiryDTO convertToDTO(Inquiry inquiry) {
        return InquiryDTO.builder()
                .inquiryId(inquiry.getInquiryId())
                .userId(inquiry.getUserId().getUserId())  // Assuming User has a getUserId() method
                .workId(inquiry.getWorkId().getWorkId())  // Assuming Work has a getWorkId() method
                .inquiryDate(inquiry.getInquiryDate())
                .inquiryAddress(inquiry.getInquiryAddress())
                .inquiryContent(inquiry.getInquiryContent())
                .inquiryTitle(inquiry.getInquiryTitle())
                .comments(inquiry.getComments().stream()
            			.map(this::convertCommentToDTO)
            			.collect(Collectors.toList()))
                .build();
    }
	
	// Entity to DTO conversion
	private CommentDTO convertCommentToDTO(Comment comment) {
	    return CommentDTO.builder()
	            .comId(comment.getComId())
	            .inquiryId(comment.getInquiryId().getInquiryId())  // Inquiry 엔티티에서 inquiryId 가져오기
	            .comContent(comment.getComContent())
	            .comConsign(comment.getComConsign())
	            .build();
	}
	
	// DTO to Entity conversion
    private Inquiry convertToEntity(User user, Work work, InquiryDTO dto) {
        return Inquiry.builder()
                .userId(user)  // Assuming User has a constructor that takes userId
                .workId(work)  // Assuming Work has a constructor that takes workId
                .inquiryDate(dto.getInquiryDate())
                .inquiryAddress(dto.getInquiryAddress())
                .inquiryContent(dto.getInquiryContent())
                .inquiryTitle(dto.getInquiryTitle())
                .build();
    }

	@Override
	public List<AllInquiryDTO> getAllInquiry() {

		List<Inquiry> inquiryEntityList = inquiryDAO.findAll();
		System.out.println("getAllInquiry() : " + inquiryEntityList);
		
//		List<AllInquiryDTO> inquiryDTOList = inquiryEntityList.stream()
//		        .map(this::convertToDTO)
//		        .collect(Collectors.toList());
		
		List<AllInquiryDTO> inquiryDTOList = inquiryEntityList.stream()
		        .map(inquiry -> new AllInquiryDTO(
		            inquiry.getInquiryId(),
		            inquiry.getUserId() != null ? inquiry.getUserId().getUserName() : "Unknown", // Null 체크와 기본값 설정
		            inquiry.getWorkId() != null ? inquiry.getWorkId().getWorkName() : "Unknown", // Null 체크와 기본값 설정
		            inquiry.getInquiryDate(),
		            inquiry.getInquiryTitle()
		        ))
		        .collect(Collectors.toList());
		
		return inquiryDTOList;
	}

	@Override
	public InquiryDTO getInquiry(long inquiryId) throws NotExistInquiryException {

		Inquiry inquiryEntity = inquiryDAO.findByInquiryId(inquiryId);
		logger.debug("inquiryEntity() : " + inquiryEntity);
		
		if (inquiryEntity == null) {
			logger.warn("Inquiry 상세조회 실패");
			throw new NotExistInquiryException("해당 의뢰는 존재하지 않습니다.");
		}
		
		InquiryDTO inquiryDTO = convertToDTO(inquiryEntity);
		logger.debug("inquiryDTO() : " + inquiryDTO);
		logger.info("Inquiry 상세조회 성공");
		return inquiryDTO;
	}

	@Override
	public Inquiry postInquiry(InquiryDTO inquiryDTO) throws NotExistInquiryException {
		
		long seesionUserId = (long)httpSession.getAttribute("userId");
		User user = userDAO.findByUserId(seesionUserId);
		
		Work work = workDAO.findByWorkId(inquiryDTO.getWorkId());
		
		if (user == null) {
			logger.warn("Inquiry 작성 실패");
			throw new NotExistInquiryException("작성자 정보가 누락되었습니다.");
		}
		
		Inquiry inquiry = convertToEntity(user, work, inquiryDTO);
		Inquiry result = inquiryDAO.save(inquiry);
		// TODO Auto-generated method stub
		return result;
	}
	
	@Override
	public Comment postComment(CommentDTO commentDTO) throws NotExistInquiryException {

		Inquiry inquiry = inquiryDAO.findByInquiryId(commentDTO.getInquiryId());
		
		if (inquiry == null) {
			logger.warn("Comment 작성 실패");
			throw new NotExistInquiryException("해당 의뢰는 존재하지 않습니다.");
		}
		
		Comment comment = mapper.map(commentDTO, Comment.class);
		Comment result = commentDAO.save(comment);
		
		return result;
	}

}
