package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "card_details", schema = "shopmanagement", catalog = "")
public class CardDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private Integer price;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDetailsEntity that = (CardDetailsEntity) o;
        return id == that.id && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}
