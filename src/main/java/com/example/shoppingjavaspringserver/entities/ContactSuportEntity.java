package com.example.shoppingjavaspringserver.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contact_suport", schema = "shopmanagement", catalog = "")
public class ContactSuportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "issue_tye")
    private String issueTye;
    @Basic
    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssueTye() {
        return issueTye;
    }

    public void setIssueTye(String issueTye) {
        this.issueTye = issueTye;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactSuportEntity that = (ContactSuportEntity) o;
        return id == that.id && Objects.equals(issueTye, that.issueTye) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueTye, description);
    }
}
