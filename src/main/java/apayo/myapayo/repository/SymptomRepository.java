package apayo.myapayo.repository;


import apayo.myapayo.domain.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SymptomRepository {

    private final EntityManager em;
    //part의 id에 대한 symptom_list를 반환한다.
//    public List<Symptom> findByPart(Long id) {
//        return em.createQuery("select s from Partsymptomlink psl " +
//                        "fetch join psl.part p fetch join psl.symptom s " +
//                        "where p.id = :id", Symptom.class)
//                .setParameter("id",id)
//                .getResultList();
//    }

    public List<Symptom> findByPart(Long id) {
        return em.createQuery("select distinct s from Partsymptomlink psl " +
                        "join psl.part p " +
                        "join psl.symptom s " +
                        "where p.id = :id", Symptom.class)
                .setParameter("id", id)
                .getResultList();
    }

}
