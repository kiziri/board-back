package com.board.boardback.repository;


import com.board.boardback.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }
}
