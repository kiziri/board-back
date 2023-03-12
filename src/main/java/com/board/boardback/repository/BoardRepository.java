package com.board.boardback.repository;


import com.board.boardback.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }

    public Board findById(Board board) {
        return em.find(Board.class, board.getBoardId());
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

    public List<Board> findAllByMemberId(Board board) {
        return em.createQuery("select b from Board b where b.member.memberId = :memberId", Board.class)
                .setParameter("memberId", board.getMember().getMemberId()).getResultList();
    }

    public Board updateBoard(Board board) {
        em.persist(board);
        return em.find(Board.class, board.getBoardId());
    }

    public void deleteBoard(Board board) {
        em.remove(board);
    }
}
