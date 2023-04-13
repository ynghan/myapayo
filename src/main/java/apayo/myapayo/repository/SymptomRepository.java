package apayo.myapayo.repository;


import apayo.myapayo.domain.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SymptomRepository {

    private EntityManager em;



    public List<Symptom> findByPart(Long id) { //part의 id에 대한 symptom_list를 반환한다.
        return em.createQuery("select s from Symptom s where s.id = :id",Symptom.class)
                .setParameter("id",id)
                .getResultList();
    }
}
