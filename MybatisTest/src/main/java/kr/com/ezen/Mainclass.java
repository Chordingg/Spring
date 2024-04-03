package kr.com.ezen;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mainclass {

	public static void main(String[] args) {

		// DB연결 과정
		try {
							// mybatis-config.xml이 저장되어있는 공간으로 코드 변경
			String resource = "kr/com/ezen/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			System.out.println("sqlSessionFactory : " + sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession(true);
			
			System.out.println("session : " + session);
			
			MapperInterface mapper = session.getMapper(MapperInterface.class);
			
			// blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
			
			MemberVO vo = new MemberVO();
			
			vo.setId(1);
			vo.setName("장합");
			vo.setPhone("010-3333-9999");
			vo.setAddress("서울시 도봉구");
			
			mapper.deleteMember(1);
			// mapper.updateMember(vo);
			//int result = mapper.insertMember(vo);	
			//System.out.println("성공이면 : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
