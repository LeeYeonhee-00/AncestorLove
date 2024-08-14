package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// html -> 컨트롤러 -> jsp 등으로 실행에 권장 (동기방식과 비동기 혼용)
// html <-> 컨트롤러 : 비동기 기술 적용 권장(트랜드)
// 현업에서는 혼용해서 사용
@Controller
public class StringReturnController {
	// http://localhost/step14/fisa
	@RequestMapping(path="/fisa", method = RequestMethod.GET)
	public ModelAndView m1() {
		
		System.out.println("m1() **************");
		
		ModelAndView mv = new ModelAndView();
		
		//main.jsp에서 controller에서 저장한 데이터 출력
		// request.setAttirbute("msg", "서버에서 저장한 데이터");
		mv.addObject("msg","서버에서 저장한 데이터");
	
		mv.setViewName("main"); // 지정하는 설정 (/WEB-INF/main.jsp)
		
		// 기존 forward 코드보다 간결
		return mv; // forward 방식
	}
	
	// forward와 redirect 방식구분
	/* index.html -> Subcontroller -> main.jsp
	 * (static) 	 
	 */
	@RequestMapping(path = "fisa1", method = RequestMethod.GET)
	public String m2() {
		System.out.println("m2() *****");
		return "main"; // main.jsp 정상실행
	}
	
	// forward 방식으로 main으로 이동
	@RequestMapping(path = "fisa2", method = RequestMethod.GET)
	public String m22(@RequestParam("id") String id) {
		System.out.println("m22() *****");
		return "main"; // @RequestParam String id -> status 500 애러
						// @RequestParam("id") String id) -> 정상실행
	
}
	// id를 넘겼음에도, id가 안나옴 -> redirect
	@RequestMapping(path = "fisa3", method = RequestMethod.GET)
	public String m3(@RequestParam("id") String id) {
		System.out.println("m3() *****");
		return "redirect:main.jsp"; // @RequestParam String id -> status 500 애러
						// @RequestParam("id") String id) -> 정상실행
	
	}
	// forward로, id 출력
	@RequestMapping(path = "fisa4", method = RequestMethod.GET)
	public String m4(@RequestParam("id") String id) {
		System.out.println("m4() *****");
		return "forward:main.jsp"; 
		}
}
/*
 * ModelAndView : 데이터, 화면 모두 가능
*/