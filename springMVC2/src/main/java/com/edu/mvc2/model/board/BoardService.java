package com.edu.mvc2.model.board;

import java.util.List;

import com.edu.mvc2.domain.Board;

//BoardDAO와 동일해보이지만 추가적인 업무가 발생시 차이가 부여된다
public interface BoardService {
	
	public List selectAll();
	public Board select(int board_idx);
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_idx);

}
