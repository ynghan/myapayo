package apayo.myapayo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Part {

    @Id @GeneratedValue
    @Column(name = "part_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "part")
    private List<Partsymptomlink> partsymptomlinks = new ArrayList<>();

    //==연관관계 메서드==//
    public void setMember(Member member){
        this.member = member;
        member.getParts().add(this);
    }

    public void addPartsymptomlink(Partsymptomlink partsymptomlink) {
        this.partsymptomlinks.add(partsymptomlink);
        partsymptomlink.setPart(this);
    }
}
