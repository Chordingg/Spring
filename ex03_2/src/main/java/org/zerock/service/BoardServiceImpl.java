package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service	// 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;

	@Override
	public void register(BoardVO board) {
		log.info("register............." + board);
		boardMapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get.........." + bno);
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify....... " + board );
		return boardMapper.update(board)  == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove....... " + bno );
		return boardMapper.delete(bno) == 1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList........... ");
//		return boardMapper.getList();
//	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList........... " + cri);
		
		return boardMapper.getListWithPaging(cri);
	}

}
