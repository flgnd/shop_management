package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "item", schema = "shopmanagement", catalog = "")
public class ItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return id == that.id && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image);
    }
}
