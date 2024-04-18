package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController // 순수한 데이터로 보여준다.  @Controller + @ResponseBody
@RequestMapping("/sample")
public class SampleController {
	
	// 단순 문자열 반환
	// produces : 해당 메서드가 생성하는 MIME 타입을 의미한다.
	@GetMapping(value = "getText", produces = "text/plain; charset=utf-8")
	public String getText() {
		
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}

	// XML 과 JSON 방식의 데이터를 생성할 수 있도록 작성함.
	@GetMapping(value = "getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, 
												  MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		
		return new SampleVO(112, "스타", "로드");
	}
	
	// produces 속성 생략
	@GetMapping(value = "getSample2")
	public SampleVO getSample2() {
		
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	// 컬렉션 타입의 객체 변환
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + "Last"))
				.collect(Collectors.toList());
	}
	
	// Map 의 경우에는 '키' 와 '값; 을 가지는 하나의 객체로 간주
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(222, "그루트", "주니어"));
		
		return map;
	}
	
	// ResponseEntity는 데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도로 사용
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	// @PathVariable : 일반 컨트롤러에서도 사용 가능 O, But REST 방식에서 자주 사용 / URL 경로의 일부를 파라미터로 사용할 때 이용
	// URL 자체에 데이터를 식별할 수 있는 정보들을 표현하는 경우
	@GetMapping(value = "/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat, 
			@PathVariable("pid") Integer pid) {
		
		return new String[] { "category : " + cat , "productid : " + pid };
	}
}
