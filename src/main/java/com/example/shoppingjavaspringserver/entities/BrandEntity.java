package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "brand", schema = "shopmanagement", catalog = "")
public class BrandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "brand_name")
    private String brandName;
    @Basic
    @Column(name = "total_quantity")
    private Integer totalQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandEntity that = (BrandEntity) o;

        if (id != that.id) return false;
        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;
        if (totalQuantity != null ? !totalQuantity.equals(that.totalQuantity) : that.totalQuantity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (totalQuantity != null ? totalQuantity.hashCode() : 0);
        return result;
    }
}
