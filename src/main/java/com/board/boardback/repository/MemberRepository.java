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


    public Member findByLoginInfo(String memberId, String password) {
        return em.createQuery("select m from Member m where m.memberId = :member_id " +
                        "and m.password = :member_pw", Member.class)
                .setParameter("member_id", memberId)
                .setParameter("member_pw", password)
                .getSingleResult();
    }

    public List<Member> findByEmailForDuplicate(String memberEmail) {
        return em.createQuery("select m from Member m where m.memberId = :memberEmail", Member.class)
                .setParameter("memberEmail", memberEmail).getResultList();
    }
}
