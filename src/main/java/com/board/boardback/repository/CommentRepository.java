package com.board.boardback.repository;

import com.board.boardback.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public List<Comment> findAllByBoardId(long boardId) {
        return em.createQuery("select c from Comment c where c.board.boardId=:boardId", Comment.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }

    public List<Comment> findAllByMemberId(String memberId) {
        return em.createQuery("select c from Comment c where c.member.memberId=:memberId", Comment.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public Comment updateComment(Comment comment) {
        em.persist(comment);

        return em.find(Comment.class, comment.getCommentId());
    }

    public void deleteComment(Comment comment) {
        em.remove(comment);
    }
}
