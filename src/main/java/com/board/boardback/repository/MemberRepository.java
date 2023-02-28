package com.board.boardback.repository;

import com.board.boardback.domain.Member;
import com.board.boardback.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
    
    // todo: Dto <--> Entity 변환 로직 필요

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

    public List<Member> getValidateDuplicateId(MemberDto memberDto) {
        return em.createQuery("select m from Member m where m.memberId = :member_id", Member.class)
                .setParameter("member_id", memberDto.getMemberId()).getResultList();
    }

    public Member getMemberAccLvl(MemberDto memberDto) {
        return em.createQuery("select m.acc_lvl from Member m where m.memberId = :member_id", Member.class)
                .setParameter("member_id", memberDto.getMemberId()).getSingleResult();
    }
}
