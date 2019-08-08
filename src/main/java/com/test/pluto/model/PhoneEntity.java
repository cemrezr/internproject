package com.test.pluto.model;

import javax.persistence.*;

@Entity
@Table(name = "phone", schema = "income", catalog = "")
public class PhoneEntity {
    private int id;
    private int number;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneEntity that = (PhoneEntity) o;

        if (id != that.id) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number;
        return result;
    }
}
