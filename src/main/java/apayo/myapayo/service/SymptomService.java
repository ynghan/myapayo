package apayo.myapayo.service;


import apayo.myapayo.domain.Symptom;
import apayo.myapayo.repository.PartRepository;
import apayo.myapayo.repository.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SymptomService {

    private final SymptomRepository symptomRepository;

    /**
     *  부위에 맞는 증상 조회
     */
    public List<Symptom> findSymptoms(Long partId) {
        return symptomRepository.findByPart(partId);
    }
}
