package com.charbz.sendzbe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "SENDS")
public class Send {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BOULDER_TYPE")
    private String boulderType;

    @Column(name = "BURN_NUMBER")
    private String burnNumber;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "GYM")
    private String gym;

    @Column(name = "HOLD_TYPE")
    private String holdType;

    @Column(name = "WALL_TYPE")
    private String wallType;

    @Column(name = "SESSION_DATE")
    private LocalDate sessionDate;

    @Column(name = "USERNAME")
    private String username;
}
