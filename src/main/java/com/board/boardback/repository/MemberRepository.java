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

    public void save(Member member) {       // 회원가입
        em.persist(member);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public Member findById(Member member) {
        return em.find(Member.class, member.getMemberId());
    }

    public Member findByMemberIdAndMemberPw(Member member) {
        return em.createQuery("select m from Member m where m.memberId = :memberId " +
                        "and m.memberPw = :memberPw", Member.class)
                .setParameter("memberId", member.getMemberId())
                .setParameter("memberPw", member.getMemberPw())
                .getSingleResult();
    }

    public List<Member> getDuplicateId(Member member) {
        return em.createQuery("select m from Member m where m.memberId = :memberId", Member.class)
                .setParameter("memberId", member.getMemberId()).getResultList();
    }

    public Member getMemberAccLvl(Member member) {
        return em.createQuery("select m.accLvl from Member m where m.memberId = :memberId", Member.class)
                .setParameter("memberId", member.getMemberId()).getSingleResult();
    }

    public Member updateMember(Member member) {
        em.persist(member);

        return em.find(Member.class, member.getMemberId());
    }

    public void deleteMember(Member member) {
        em.remove(member);
    }
}
