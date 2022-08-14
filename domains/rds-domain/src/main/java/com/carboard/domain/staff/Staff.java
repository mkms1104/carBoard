package com.carboard.domain.staff;

import com.carboard.domain.metaEntity.Address;
import com.carboard.domain.metaEntity.BaseTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long id;
    private String name;
    private LocalDate birth;
    private String phone;

    @Embedded
    private Address address;
    private LocalDate joinDate;
    private LocalDate resignationDate;
    private String note;

    public void setAddress(Address address) {
        this.address = address;
    }

}
