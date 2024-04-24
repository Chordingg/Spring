package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	// 댓글 추가하기 위해서 현존하는 게시글 번호들
	private Long[] bnoArr = {7811L, 7809L, 7808L, 7805L, 7804L};
	
	@Test
	public void testMapper() {
		log.info(replyMapper);
	}
	
	// Create //
	@Test
	public void testCreate() {
		
		// 1~100까지 forEach 통해서 보내준다.
		IntStream.range(1, 101).forEach(i -> {
		
		ReplyVO vo = ReplyVO.builder()
				// 게시글 번호가 존재 X 오류 뜸
				// .bno(999999999L)
				
				// 1~100 % 5를 함으로써 0~4 까지의 배열 순서에 따라 넣어준다.
				.bno(bnoArr[i%5])
				.reply("댓글 테스트" + i)
				.replyer("replyer" + i)
				.build();
		
		replyMapper.insert(vo);
		
		});
	} 
		
	// Read //
	@Test
	public void testRead() {
		log.info(replyMapper.read(134L));
	}
		
	// Update //
	@Test
	public void testUpdate() {
		
		ReplyVO vo = ReplyVO.builder()
				.rno(134L)
				.reply("댓글 수정 테스트")
				.build();
		
		log.info(replyMapper.update(vo));
	}
	
		
	// Delete //
	@Test
	public void testDelete() {
		log.info(replyMapper.delete(144L));
	}
	
	// 전체 데이터 가져오기
	@Test
	public void testGetList() {
		Criteria cri = new Criteria();
		List<ReplyVO> list = replyMapper.getListWithPaging(cri, bnoArr[0]);
		
		list.forEach(reply -> log.info(reply));
	}


}
