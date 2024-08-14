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
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.CommentDTO;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.entity.Comment;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.model.entity.User;
import com.ce.fisa.model.entity.Work;

@Service
public class InquiryServiceImpl implements InquiryService {
	
	private static final Logger logger = LogManager.getLogger(PartnerController.class);
	
	@Autowired
	private InquiryRepository inquiryDAO;
	
	@Autowired
	private CommentRepository commentDAO;
	
	// DTO <-> Entity
	private ModelMapper mapper = new ModelMapper();
	
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
	
	
	private CommentDTO convertCommentToDTO(Comment comment) {
	    return CommentDTO.builder()
	            .comId(comment.getComId())
	            .inquiryId(comment.getInquiryId().getInquiryId())  // Inquiry 엔티티에서 inquiryId 가져오기
	            .comContent(comment.getComContent())
	            .comConsign(comment.getComConsign())
	            .build();
	}
	
	// DTO to Entity conversion if needed
//    private Inquiry convertToEntity(InquiryDTO dto) {
//        return Inquiry.builder()
//                .inquiryId(dto.getInquiryId())
//                .userId(dto.getUserId())  // Assuming User has a constructor that takes userId
//                .workId(dto.getWorkId())  // Assuming Work has a constructor that takes workId
//                .inquiryDate(dto.getInquiryDate())
//                .inquiryAddress(dto.getInquiryAddress())
//                .inquiryContent(dto.getInquiryContent())
//                .inquiryTitle(dto.getInquiryTitle())
//                .build();
//    }

	@Override
	public List<InquiryDTO> getAllInquiry() {

		List<Inquiry> inquiryEntityList = inquiryDAO.findAll();
		System.out.println("getAllInquiry() : " + inquiryEntityList);
		
		List<InquiryDTO> inquiryDTOList = inquiryEntityList.stream()
		        .map(this::convertToDTO)
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
