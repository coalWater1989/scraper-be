package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "GYMS")
public class Gym {
    @Id
    @Column(name = "GYM")
    private String gym;
}
