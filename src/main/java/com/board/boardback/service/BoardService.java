package com.board.boardback.service;

import com.board.boardback.dto.BoardDto;

import java.util.List;

public interface BoardService {
    Long saveBoard(BoardDto boardDto);


    BoardDto findById(BoardDto boardDto);


    List<BoardDto> findAll(BoardDto boardDto);


    int getBoardViewCount(Long boardId);


    int getBoardCommentCount(Long boardId);


    BoardDto updateBoard(BoardDto boardDto);


    void deleteBoard(BoardDto boardDto);
}
