package apayo.myapayo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String age;

    private String sex;

    private LocalDateTime birthday;

    @OneToMany(mappedBy="member")
    private List<Part> parts = new ArrayList<>();

}