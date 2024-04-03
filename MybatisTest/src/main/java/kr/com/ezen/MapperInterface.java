package kr.com.ezen;

public interface MapperInterface {
	
	int insertMember(MemberVO vo);
	int updateMember(MemberVO vo);
	int deleteMember(int id);

}
