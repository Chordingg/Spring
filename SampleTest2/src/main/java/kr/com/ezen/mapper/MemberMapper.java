package kr.com.ezen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.com.ezen.dto.MemberVO;

public interface MemberMapper {
	
	// 어노테이션 기법으로 할 수도 있음
	@Select("select sysdate from dual")
	public String getTime();

	// xml 방식
	public String getTime2();
	
	public int insertMember(MemberVO vo);
	
	public int updateMember(MemberVO vo);
	
	public int deleteMember(int id);
	
	public MemberVO selectOneMember(int id);
	
	public List<MemberVO> selectAllMember();
}
