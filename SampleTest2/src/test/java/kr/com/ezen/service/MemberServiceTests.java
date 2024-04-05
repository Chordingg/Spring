package kr.com.ezen.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTests {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(200)
				.name("장비")
				.phone("010-6246-8231")
				.address("서울시 도곡동")
				.build();
		
		memberService.insertMember(vo);
		
	}
	
	@Test
	public void testList() {
		memberService.list().forEach(vo -> log.info(vo));
	}

	
	
}
