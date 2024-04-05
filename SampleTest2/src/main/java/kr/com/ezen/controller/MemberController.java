package kr.com.ezen.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member")	// 모든 요청이 여기로..
@RequiredArgsConstructor	// 생성자 주입
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/")
	public String member(Model model) {
		log.info("------------------------------");
		String msg = "정형돈";
		model.addAttribute("name", msg);
		return "member";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberVO> list = memberService.list();
		
		list.forEach(vo -> log.info(vo));
		model.addAttribute("list" , list);
		
		return "memberList";
	}
	
	@PostMapping("/insert")
	public String insert(MemberVO vo) {
		
		log.info("------------------------------");
		log.info(vo);
		
		// 저장
		memberService.insertMember(vo);
		
		return null;
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		log.info("delete : " + id);
		// 삭제
		memberService.deleteMember(id);
		
		return null;
	}
	
	
	
}
