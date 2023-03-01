package com.board.boardback.service;

import com.board.boardback.domain.Member;
import com.board.boardback.dto.MemberDto;
import com.board.boardback.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원 정보 저장
     * @param memberDto
     * @return 저장된 회원 아이디
     */
    @Override
    @Transactional
    public String saveMember(MemberDto memberDto) {

        if (getDuplicateId(memberDto)) {
            memberRepository.save(memberDto.dtoToMemberEntity());
        }

        return memberDto.getMemberId();
    }

    /**
     * 모든 회원 정보 목록 조회
     * @return 전체 회원 정보 리스트
     */
    @Override
    public List<MemberDto> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 회원 아이디 단건 회원 정보 조회
     * @param memberDto
     * @return 단일 회원 정보
     */
    @Override
    public MemberDto findById(MemberDto memberDto) {
        Member findMember = memberRepository.findById(memberDto.dtoToMemberEntity());

        return findMember.entityToMemberDto();
    }

    /**
     *
     * @param memberDto
     * @return 정상시 True
     */
    @Override
    public boolean getDuplicateId(MemberDto memberDto) {
        List<Member> getDuplicateMembers = memberRepository.getDuplicateId(memberDto.dtoToMemberEntity());

        if (!getDuplicateMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return true;
    }

    /**
     * 회원의 접근레벨 조회
     * @param memberDto
     * @return accLvl
     */
    @Override
    public String getMemberAccLvl(MemberDto memberDto) {
        MemberDto getMemberdto = memberRepository.getMemberAccLvl(memberDto.dtoToMemberEntity()).entityToMemberDto();

        return getMemberdto.getAccLvl();
    }

    /**
     * 회원 정보 수정
     * @param memberDto
     * @return 수정된 회원 정보
     */
    @Override
    public MemberDto updateMember(MemberDto memberDto) {
        Member updateMember = memberRepository.updateMember(memberDto.dtoToMemberEntity());

        return updateMember.entityToMemberDto();
    }

    /**
     * @param memberDto
     * @ 회원 정보 삭제
     */
    @Override
    public void deleteMember(MemberDto memberDto) {
        memberRepository.deleteMember(memberDto.dtoToMemberEntity());
    }
}
