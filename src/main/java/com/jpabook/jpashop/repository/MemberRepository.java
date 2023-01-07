package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // 컴포넌트 스캔의 대상이 되어 스프링 빈에 등록된다.
public class MemberRepository {

    @PersistenceContext // Entity 매니저 주입
    private EntityManager em;

    // 회원 저장
    public void save(Member member){
        em.persist(member);
    }

    // 회원 조회(ID로 조회)
    public Member fineOne(Long id){
        return em.find(Member.class, id); // 단건 조회
                        // type, PK

    }

    // 전체 회원 목록 조회
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //회원 조회(이름으로 찾기)
    public List<Member> findByName(String name){                            //바인딩 된 파라미터 값
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name) // 파라미터 바인딩
                .getResultList();
    }
}
