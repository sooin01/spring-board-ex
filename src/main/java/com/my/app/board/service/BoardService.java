package com.my.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.board.model.Board;
import com.my.app.common.dao.CommonDao;

@Service
public class BoardService {

	@Autowired
	private CommonDao commonDao;

	public int getBoardCount(Board board) {
		return commonDao.selectOne("Board.selectBoardCount", board);
	}

	public List<Board> getBoardList(Board board) {
		return commonDao.selectList("Board.selectBoardList", board);
	}

	public Board getBoard(Board board) {
		return commonDao.selectOne("Board.selectBoard", board);
	}

	public int insertBoard(Board board) {
		return commonDao.insert("Board.insertBoard", board);
	}

}
