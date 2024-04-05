package kr.com.ezen.persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Autowired
	private MemberMapper mapper;

	@Test
	public void testConnection() {
		try {
			SqlSession session = sessionFactory.openSession();
			log.info("session : " + session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTime() {
		try {
			log.info("----------------------------");
			log.info(mapper.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTime2() {
		log.info("----------------------------");
		log.info(mapper.getTime2());
	}
}
