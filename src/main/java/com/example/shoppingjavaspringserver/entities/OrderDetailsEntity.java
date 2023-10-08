package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_details", schema = "shopmanagement", catalog = "")
public class OrderDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "total")
    private Integer total;
    @Basic
    @Column(name = "column_name")
    private Integer columnName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getColumnName() {
        return columnName;
    }

    public void setColumnName(Integer columnName) {
        this.columnName = columnName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsEntity that = (OrderDetailsEntity) o;
        return id == that.id && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price) && Objects.equals(total, that.total) && Objects.equals(columnName, that.columnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, price, total, columnName);
    }
}
