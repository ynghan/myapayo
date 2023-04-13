package apayo.myapayo.service;


import apayo.myapayo.domain.Part;
import apayo.myapayo.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    /**
     * 모든 부위 조회
     */
    public List<Part> findAllParts() {
        return partRepository.findAll();
    }
    /**
     * 특정 부위 조회
     */
    public Part findOne(Long partId) {
        return partRepository.findOne(partId);
    }

}
