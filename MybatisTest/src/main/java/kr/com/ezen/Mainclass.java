package kr.com.ezen;

import java.io.InputStream;
import java.util.List;

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
			vo.setName("아지");
			vo.setPhone("010-5555-3333");
			vo.setAddress("경기도 화성시");
			
			// mapper.deleteMember(1);
			// mapper.updateMember(vo);
			// int result = mapper.insertMember(vo);	
			// System.out.println("성공이면 : " + result);
			
			// vo = mapper.selectMemberOne(1);
			List<MemberVO> list  = mapper.selectMemberList();
			
			for(MemberVO vo2 : list) {
			System.out.println("list : " + vo2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
