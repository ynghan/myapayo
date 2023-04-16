package apayo.myapayo.controller;

import apayo.myapayo.domain.Part;
import apayo.myapayo.service.PartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    /**모든 부위 조회
     *
     */
//    @GetMapping("/parts")
//    public ResponseEntity<List<Part>> list() {
//
//        List<Part> parts = partService.findAllParts();
//
//        return new ResponseEntity<>(parts, HttpStatus.OK);
//    }

    @GetMapping("/parts")
    public Result part2() {
        List<Part> findParts = partService.findAllParts();
        List<PartDto> collect = findParts.stream()
                .map(p -> new PartDto(p.getId(), p.getName()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class PartDto {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
