package com.board.boardback.service;

import com.board.boardback.dto.BoardDto;

import java.util.List;

public interface BoardService {
    /**
     * 신규 게시글 등록
     * @param boardDto
     * @return 신규 등록한 게시글 아이디
     */
    Long saveBoard(BoardDto boardDto);

    /**
     * 아이디 기반 게시글 정보 조회
     * @param boardDto
     * @return 게시글 아이디 기준 조회한 게시글 정보
     */
    BoardDto findById(BoardDto boardDto);

    /**
     * 게시판 전체 리스트 조회
     * @return 전체 게시글 리스트
     */
    List<BoardDto> findAll();

    /**
     * 회원의 전체 게시글 조회
     * @param boardDto
     * @return 회원의 전체 게시글
     */
    List<BoardDto> findAllById(BoardDto boardDto);

    /**
     * 게시글 수정
     * @param boardDto
     * @return 수정된 게시글 정보
     */
    BoardDto updateBoard(BoardDto boardDto);

    /**
     * 게시글 삭제
     * @param boardDto
     */
    void deleteBoard(BoardDto boardDto);
}
