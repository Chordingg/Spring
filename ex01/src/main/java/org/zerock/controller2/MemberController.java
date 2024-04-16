package org.zerock.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
}


//===> localhost:8181/member/hello  ====>     hello     문자가 출력된다.