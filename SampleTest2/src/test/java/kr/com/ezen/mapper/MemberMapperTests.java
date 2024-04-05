package kr.com.ezen.mapper;

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
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(100)
				.name("강조")
				.phone("010-3463-2172")
				.address("수원시 팔달구")
				.build();
		log.info(mapper.insertMember(vo));
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(100)
				.name("장합")
				.phone("010-2358-2346")
				.address("경기도 수원시")
				.build();
		mapper.updateMember(vo);
	}
	
	@Test
	public void testDelete() {
		mapper.deleteMember(100);
	}
	
	@Test
	public void testSelectOne() {
		log.info(mapper.selectOneMember(15));
	}
	
	@Test
	public void testSelectAll() {
		mapper.selectAllMember().forEach(vo -> log.info(vo));
	}
}
