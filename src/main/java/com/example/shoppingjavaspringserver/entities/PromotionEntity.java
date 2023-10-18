package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "promotion", schema = "shopmanagement", catalog = "")
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "value")
    private int value;
    @Basic
    @Column(name = "availability")
    private int availability;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionEntity that = (PromotionEntity) o;
        return id == that.id && value == that.value && availability == that.availability && Objects.equals(code, that.code) && Objects.equals(date, that.date) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, value, availability, date, status);
    }
}
