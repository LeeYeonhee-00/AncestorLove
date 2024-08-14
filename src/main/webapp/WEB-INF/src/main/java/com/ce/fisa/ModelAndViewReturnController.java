package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// http 통신이 가능한 컨트롤러 설정
@Controller
public class ModelAndViewReturnController {
	
	// url 자체도 데이터로 구성하는 URL template 기술적용
	// 문법 : path/{key}/subpath
	// 		-> @PathVariable("key")
	@RequestMapping("fisa8/{id}/tester")
	// url PATH 값을 파라미터로 쓰겠음
	// public String m8(@PathVariable String id)
	public String m8(@PathVariable("id") String id) {
		System.out.println("m8() ********" + id);
		// http://localhost/step14/fisa8/id/tester
		// http://localhost/step14/main.jsp
		return "redirect:/main.jsp";
	}
	
	
	
	
	/* url 구성연습
	 * 1단계 - 에러발생
	 * 		: return "redirect:main.jsp"; 미존재경로 애러
	 * 2단계 - 해결책
	 * 		: 경로 수정 return "redirect:/main.jsp";
	 * 		: context명 인식할 수 있게끔 '/' 추가
	 */
	@RequestMapping("fisa7/id/tester")
	public String m7() {
		System.out.println("m7() ********");
		// 때에 따라서는 / 기법을 사용
		// http://localhost/step14/fisa7/id/main.jsp
		// http://localhost/step14/main.jsp
		return "redirect:/main.jsp";
	}
	
	
	
	@GetMapping("fisa6")
	public ModelAndView m2(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","서버에서 저장한 데이터");
		mv.setViewName("main"); 
		return mv; // forward 방식
	}
	
	
	// 데이터 저장 후 /WEB-INF/main.jsp로 이동
	@RequestMapping(path = "fisa5", method = RequestMethod.GET)
	public ModelAndView m1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","server에서 new data 저장");
		// main으로 이동
		mv.setViewName("main");
		return mv;
	}
}
