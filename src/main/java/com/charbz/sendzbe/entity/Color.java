package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "COLORS")
public class Color {
    @Id
    @Column(name = "COLOR")
    private String color;
}
