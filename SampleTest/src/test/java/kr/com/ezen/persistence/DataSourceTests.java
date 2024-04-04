package kr.com.ezen.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTests {

	@Autowired // 필드 주입
	// 컨테이너(root-context.xml)에 있는 <bean id="dataSource"> 를 가져옴 
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try {
			Connection con = dataSource.getConnection();
			log.info("--------------------------");
			log.info("con >> " + con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
