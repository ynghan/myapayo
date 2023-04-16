package apayo.myapayo.controller;


import apayo.myapayo.domain.Part;
import apayo.myapayo.domain.Symptom;
import apayo.myapayo.service.PartService;
import apayo.myapayo.service.SymptomService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SymptomController {

  //  private final PartService partService;
    private final SymptomService symptomService;

    /**
     * partId에 따른 증상 조회
     */
    @GetMapping("/api/symptoms/{partId}")
    public Result findSymptomsByPartId(
            @PathVariable("partId") Long id) {

//        Part part = partService.findOne(id);

        List<Symptom> findSymptoms = symptomService.findSymptoms(id);

        System.out.println("findSymptoms = " + findSymptoms);

        List<SymptomDto> collect = findSymptoms.stream()
                .map(s -> new SymptomDto(s.getKorean_description()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class SymptomDto {
        private String korean_description;
    }
}
