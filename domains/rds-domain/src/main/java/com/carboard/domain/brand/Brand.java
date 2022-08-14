package com.carboard.domain.brand;

import com.carboard.domain.metaEntity.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;
    @Column(unique = true)
    private String name;
    public Brand(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}
