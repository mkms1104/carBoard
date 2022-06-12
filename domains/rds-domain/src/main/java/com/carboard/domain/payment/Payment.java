package com.carboard.domain.payment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "payment_id")
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private PaymentType type;
    private double amount;
    private String note;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus status;
}
