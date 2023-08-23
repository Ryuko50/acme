package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "CREDIT_CARD")
@Getter
@Setter
public class CreditCard {
    @Column(name = "cardNumber", nullable = false, length = 16)
    private String cardNumber;
    @Column(name = "expirationMonth", nullable = false)
    private int expirationMonth;
    @Column(name = "expirationYear", nullable = false)
    private int expirationYear;
    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv;
    @Enumerated
    private CreditCardBrand creditCardBrand;
    @OneToOne
    private User user;
}
