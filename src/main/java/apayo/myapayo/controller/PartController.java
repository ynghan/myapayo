package apayo.myapayo.controller;

import apayo.myapayo.domain.Part;
import apayo.myapayo.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    //모든 부위 조회
    @GetMapping("/parts")
    public ResponseEntity<List<Part>> list() {
        List<Part> parts = partService.findAllParts();

        return new ResponseEntity<>(parts, HttpStatus.OK);
    }

    //테스트용
//    @GetMapping("/parts")
//    public ResponseEntity<String> getData() {
//        String data = "Hello, World";
//
//        return ResponseEntity.ok(data);
//    }
}
