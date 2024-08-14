//sessiontracking 공통 url
package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ce.fisa.model.domain.Customer;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("sessiontracking")
@SessionAttributes({"id","pw", "cust"}) // key값 배열로 저장
								// HttpSession의 invalidate() 메서드와 혼용사용 금지
public class SessionTracking {
	// **model로 저장된 세션 데이터 Controller 에서 확인
	@GetMapping("/sessionview")
	public String m7(@ModelAttribute("cust") Customer c) {
		System.out.println("m7 = " + c.getName());
		return "redirect:/sessionView.jsp";
	}
	
	
	
	// 2-3. sessiontest3?id=user01&name=khk&age=30"
	/* CustomerDTO or Customer or CustomerBean or CustomerVO
	 * 
	 * client가 새로운 데이터를 전송 -> controller 데이터 받음 
	 * 			-> service -> dao -> db
	 * 			-> dao -> service -> controller -> sessionView.jsp
	 * 
	 * sessionView.jsp
	 * ${sessionScope.cust.id}-${sessionScope.cust.name}
	 * 
	 * Model
	 * 	- 세션(@SessionAttributes({".."})과 함께 사용시 HttpSession 의미
	 * 	- forward 방식으로 jsp로 이동 시에 해당 로직의 메서드
	 * 	  (parameter로 선언 시 HttpServletRequest 의미)
	 * 
	 */
	@GetMapping("/sessiontest3")
	public String m6(Customer cust, Model sessionModel) {
		System.out.println("m6() : " + cust);
		
		//@SessionAttribute에 등록한 key 저장
		// session.setAttribute("cust",cust) 동일
		// 세션관리 - SessionStatus의 setComplete()
		sessionModel.addAttribute("cust", cust); 
		
		return "redirect:/sessionView.jsp";
	}
	
	
	// 5. logout2
	// @SessionAttributes 선언으로 사용한 세션 소멸
	@GetMapping("/logout2")
	public String m5(SessionStatus status) {
		status.setComplete();	// 세션 소멸
//		status = null;
		System.out.println("m5 : " + status + "세션 소멸 성공");
		return "redirect:/sessionView.jsp";
	}
	
	
	
	// 4. sessiontest2
	/* Spring API로 작업시
	 * 1단계 : class 선언구에 사용하고자 하는 섹션 key명 등록
	 * 			@SessionAttributes({"id","pw"})
	 * 2단계 : controller에서 설정한 key로 데이터 획득
	 * 			@ModelAttribute("id") String id,
					@ModelAttribute("pw") String pw
					-> (동일)
				HttpSession session = request.getSession
				String id = (String)session.getAttribute
	 */
	@GetMapping("/sessiontest2")
	public String m4(@ModelAttribute("id") String id,
					@ModelAttribute("pw") String pw) {
		System.out.println("m4() : " + id + "and" + pw);
		return "redirect:/sessionView.jsp";
	}
	
	
	
	
	// 2-1. sessiontracking/logout1 버튼 클릭시, HttpSession API로 생성된 세션 삭제
	@GetMapping("/logout1")
	public String m3(HttpSession session1) {
		System.out.println("m3()" + session1.getAttribute("id"));
		session1.invalidate();
		session1 = null;
		return "redirect:/sessionView.jsp";
	}
	
	
	//2. HttpSessionAPI를 사용한 개발 기술
	/* 세션 기반의 개발 코드
	 * 	1. HttpSession API
	 * 	2. Spring API 
	 * 		- 사용하려는 key 사전에 등록
	 * 			session.setAttribute("id", "user01");
				session.setAttribute("pw", "77");
	 * 
	 */
	// ST.jsp		  -> ST.java			-> SV.jsp
	// 생성 및 데이터 저장 -> 생성된 세션 공유해서 받음 -> 생성된 세션 공유해서 받음
	// session은 forward가 아니여도 상관없음
	@GetMapping("/sessiontest")
	public String m2(HttpSession session) {
		System.out.println("m2()---" + session.getAttribute("id"));
		return "redirect:/sessionView.jsp";
	}
		
	
	// 1-1. <a href="sessiontracking/cookietest"> -> get (url타는 건 get!)
	@GetMapping("/cookietest")
	public String m1(@CookieValue("id") String value) {
		System.out.println("m1() ---- test" + value);
		return "redirect:/cookieView.jsp"; // -> step14/cookieView.jsp
	}
	
}
