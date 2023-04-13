package apayo.myapayo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Symptom {

    @Id @GeneratedValue
    @Column(name = "symptom_id")
    private Long id;

    private String korean_description;
    private String english_description;

    @OneToMany(mappedBy="symptom")
    private List<Partsymptomlink> partsymptomlinks = new ArrayList<>();

}
