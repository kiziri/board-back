package com.board.boardback.service;

import com.board.boardback.domain.Board;
import com.board.boardback.domain.Member;
import com.board.boardback.dto.BoardDto;
import com.board.boardback.repository.BoardRepository;
import com.board.boardback.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    /**
     * 신규 게시글 등록
     * @param boardDto
     * @return 신규 등록한 게시글 아이디
     */
    @Override
    public Long saveBoard(BoardDto boardDto) {
        Member memberInfo = memberRepository.findById(boardDto.getMember());
        Board newBoardInfo = boardDto.dtoToBoardEntity();

        newBoardInfo.setMember(memberInfo);
        boardRepository.save(newBoardInfo);

        return boardDto.getBoardId();
    }

    /**
     * 아이디 기반 게시글 정보 조회
     * @param boardDto
     * @return 게시글 아이디 기준 조회한 게시글 정보
     */
    @Override
    public BoardDto findById(BoardDto boardDto) {
        Board findBoard = boardRepository.findById(boardDto.dtoToBoardEntity());
        return findBoard.entityToBoardDto();
    }

    /**
     * 게시판 전체 리스트 조회
     * @return 전체 게시글 리스트
     */
    @Override
    public List<BoardDto> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 회원의 전체 게시글 조회
     * @param boardDto
     * @return 회원의 전체 게시글
     */
    @Override
    public List<BoardDto> findAllById(BoardDto boardDto) {
        return boardRepository.findAllByMemberId(boardDto.dtoToBoardEntity())
                .stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 게시글 수정
     * @param boardDto
     * @return 수정된 게시글 정보
     */
    @Override
    public BoardDto updateBoard(BoardDto boardDto) {
        return boardRepository.updateBoard(boardDto.dtoToBoardEntity())
                .entityToBoardDto();
    }

    /**
     * 게시글 삭제
     * @param boardDto
     */
    @Override
    public void deleteBoard(BoardDto boardDto) {
        boardRepository.deleteBoard(boardDto.dtoToBoardEntity());
    }
}
