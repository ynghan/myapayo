package apayo.myapayo.controller;


import apayo.myapayo.domain.Part;
import apayo.myapayo.domain.Symptom;
import apayo.myapayo.service.PartService;
import apayo.myapayo.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SymptomController {

    private final PartService partService;
    private final SymptomService symptomService;

    //부위ID에 따른 증상 조회
    @PostMapping("/symptoms")
    public ResponseEntity<List<Symptom>> list(@RequestParam Long partId) {

        List<Symptom> symptoms = symptomService.findSymptoms(partId);
        return ResponseEntity.ok(symptoms);
    }
}
