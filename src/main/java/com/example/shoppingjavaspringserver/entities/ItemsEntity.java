package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "items", schema = "shopmanagement", catalog = "")
public class ItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "discount")
    private Integer discount;
    @Basic
    @Column(name = "status")
    private Integer status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsEntity that = (ItemsEntity) o;
        return id == that.id && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && Objects.equals(discount, that.discount) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity, discount, status);
    }
}
