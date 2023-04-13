package apayo.myapayo.repository;

import apayo.myapayo.domain.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PartRepository {

    private final EntityManager em;


    public List<Part> findAll() { //모든 부위 리스트 조회
        return em.createQuery("select p from Part p", Part.class)
                .getResultList(); //JPQL로 쿼리를 날려 리스트를 반환한다.
    }

    public Part findOne(Long id) { //특정 부위 조회
        return em.find(Part.class, id);
    }
}
