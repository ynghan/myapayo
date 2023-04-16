package apayo.myapayo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Partsymptomlink {

    @Id @GeneratedValue
    @Column(name = "partsymptomlink_id")
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="part_id")
    private Part part;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;
}
