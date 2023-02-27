package com.board.boardback.repository;

import com.board.boardback.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Member findById(String memberId) {
        return em.find(Member.class, memberId);
    }

    public void save(Member member) {       // 회원가입
        em.persist(member);
    }


    public Member findByLoginInfo(String memberId, String memberPw) {
        return em.createQuery("select m from Member m where m.memberId = :memberId " +
                        "and m.memberPw = :memberPw", Member.class)
                .setParameter("memberId", memberId)
                .setParameter("memberPw", memberPw)
                .getSingleResult();
    }

    public List<Member> findByEmailForDuplicate(String memberEmail) {
        return em.createQuery("select m from Member m where m.memberId = :memberEmail", Member.class)
                .setParameter("memberEmail", memberEmail).getResultList();
    }
}
