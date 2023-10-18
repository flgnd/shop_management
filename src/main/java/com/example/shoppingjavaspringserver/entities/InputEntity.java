package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "input", schema = "shopmanagement", catalog = "")
public class InputEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "itemsid")
    private int itemsid;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "input_quantity")
    private int inputQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemsid() {
        return itemsid;
    }

    public void setItemsid(int itemsid) {
        this.itemsid = itemsid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInputQuantity() {
        return inputQuantity;
    }

    public void setInputQuantity(int inputQuantity) {
        this.inputQuantity = inputQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputEntity that = (InputEntity) o;
        return id == that.id && itemsid == that.itemsid && inputQuantity == that.inputQuantity && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemsid, date, inputQuantity);
    }
}
