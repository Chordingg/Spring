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

@Builder	// builder 쓰기 위해서는 필수적으로 필요한 것들
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	private int id;
	private String name;
	private String phone;
	private String address;
	
	
	
}
