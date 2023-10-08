package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "shopmanagement", catalog = "")
public class OrdersEntity {
    @Basic
    @Column(name = "order_date")
    private Timestamp orderDate;
    @Basic
    @Column(name = "payment_method")
    private Integer paymentMethod;
    @Basic
    @Column(name = "payment_detail")
    private Integer paymentDetail;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(Integer paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id && Objects.equals(orderDate, that.orderDate) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(paymentDetail, that.paymentDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, paymentMethod, paymentDetail, id);
    }
}
