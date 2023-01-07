package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional (readOnly = true)//readOnly = true 시, jpa가 조회에 대해 성능을 최적화해줌.
//@AllArgsConstructor // 생성자
@RequiredArgsConstructor // final이 있는 필드에만 생성자를 만들어준다.
public class MemberService {

//    @Autowired
//    private MemberRepository memberRepository;
// Autowired 방식도 많이 사용하지만, 요즘 권장되는 것은 final anotation
    private final MemberRepository memberRepository;

    // 기본 생성자 -> AllArgsConstructor 어노테이션으로 생성 가능
//    public MemberService (MemberRepository memberRepository){
//        this.memberRepository =memberRepository;
//    }

    // 회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId(); // id 반환
    }
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }


    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 단건 조회
    public Member findOne(Long memberId){
        return memberRepository.fineOne(memberId);
    }
}
