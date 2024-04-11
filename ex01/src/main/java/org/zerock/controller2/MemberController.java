package org.zerock.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Log4j
//@Controller
@RestController
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping("")
	public void test() {
		log.info("hello test .........");
	}
	
	@GetMapping("/hello")
	public String hello(SampleDTO dto, Model model) {
		log.info("hello...................");
		model.addAttribute("test", dto);
		return "hello";
	}
	
	@GetMapping("/hello1")
	@ResponseBody
	public String hello1() {
		log.info("hello...................");
		return "hello!!!";
	}
	

}

// => localhost:8181/member/hello ==>  hello 문자가 출력된다.