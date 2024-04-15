package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

	private final BoardService boardService;
	
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model){	// views/board/list.jsp
		log.info("list..................." + cri);
		
		model.addAttribute("list", boardService.getList(cri));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register................" + board);
		boardService.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());	
		
		return "redirect:/board/list";	// views/board/list.jsp
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("get + modify .............." + bno);
		
		model.addAttribute("board", boardService.get(bno));  // views/board/get.jsp
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify................" + board);
		
		if(boardService.modify(board)) {	// board값 입력 받아서 수정 성공하면 true, 실패하면 false
			rttr.addFlashAttribute("result", "modify");
		}
		
		return "redirect:/board/list";  // views/board/list.jsp
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove......................." + bno);
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "delete");
		}
		
		return "redirect:/board/list"; 	// views/board/list.jsp
	}
	
	
	
	
	
}
