package com.board.boardback.service;

import com.board.boardback.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    @Override
    public Long saveBoard(BoardDto boardDto) {
        return null;
    }

    @Override
    public BoardDto findById(BoardDto boardDto) {
        return null;
    }

    @Override
    public List<BoardDto> findAll(BoardDto boardDto) {
        return null;
    }

    @Override
    public int getBoardViewCount(Long boardId) {
        return 0;
    }

    @Override
    public int getBoardCommentCount(Long boardId) {
        return 0;
    }

    @Override
    public BoardDto updateBoard(BoardDto boardDto) {
        return null;
    }

    @Override
    public void deleteBoard(BoardDto boardDto) {

    }
}
