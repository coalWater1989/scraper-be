package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "GRADES")
public class Grade {
    @Id
    @Column(name = "GRADE")
    private String grade;

    @Column(name = "SORT_ID")
    private int sortId;
}
