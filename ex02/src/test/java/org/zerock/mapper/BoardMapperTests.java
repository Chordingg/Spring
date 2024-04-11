package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		boardMapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = BoardVO.builder()
				.title("새로 작성한 글")
				.content("새로 작성한 내용")
				.writer("newbie")
				.build();
				
		boardMapper.insert(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = BoardVO.builder()
				.title("새로 작성한 글3")
				.content("새로 작성한 내용3")
				.writer("newbie3")
				.build();
				
		boardMapper.insertSelectKey(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(9L);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		boardMapper.delete(4L);
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = BoardVO.builder()
				.title("수정한 글3")
				.content("수정한 내용3")
				.writer("newbies3")
				.bno(2L)
				.build();
		
		boardMapper.update(vo);
		
	}

}
