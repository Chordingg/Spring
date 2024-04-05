package kr.com.ezen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor	// 전체 받아주는거
@NoArgsConstructor	// 디폴트 생성자
public class MemberVO {
	
	private int id;
	private String name;
	private String phone;
	private String address;

}
