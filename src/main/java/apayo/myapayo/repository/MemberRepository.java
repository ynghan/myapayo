package apayo.myapayo.repository;


import apayo.myapayo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //멤버 생성
    public void save(Member member) { em.persist(member);}

    //멤버 한명 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //멤버 전체 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }


    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class) // :name이 파라미터에 바인딩되는 변수
                .setParameter("name", name)
                .getResultList();
    }
}
