package com.carboard.domain.product;

import com.carboard.domain.brand.Brand;
import com.carboard.domain.common.BaseTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTime {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "product_id")
    private Long id;

    private String name;
    private String unit;
    private String note;
    @ManyToOne
    @JoinColumn(name = "brand_brand_id")
    private Brand brand;

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
