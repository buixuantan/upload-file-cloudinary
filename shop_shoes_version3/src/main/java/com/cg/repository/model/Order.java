package com.cg.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "sessionId", nullable = false, length = 100)
    private String sessionId;

    @Column(name = "token", nullable = false, length = 100)
    private String token;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "subTotal", nullable = false)
    private Double subTotal;

    @Column(name = "itemDiscount", nullable = false)
    private Double itemDiscount;

    @Column(name = "tax", nullable = false)
    private Double tax;

    @Column(name = "shipping", nullable = false)
    private Double shipping;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "promo", length = 50)
    private String promo;

    @Column(name = "discount", nullable = false)
    private Double discount;

    @Column(name = "grandTotal", nullable = false)
    private Double grandTotal;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "middleName", length = 50)
    private String middleName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "line1", length = 50)
    private String line1;

    @Column(name = "line2", length = 50)
    private String line2;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "province", length = 50)
    private String province;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Lob
    @Column(name = "content")
    private String content;

}