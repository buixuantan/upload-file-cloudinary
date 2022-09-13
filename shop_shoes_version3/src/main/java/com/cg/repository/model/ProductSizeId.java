package com.cg.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductSizeId implements Serializable {

    private static final long serialVersionUID = -3246030675715172787L;
    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "size_id", nullable = false)
    private Long sizeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductSizeId entity = (ProductSizeId) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.sizeId, entity.sizeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sizeId);
    }
}
