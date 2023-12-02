package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "WALL_TYPES")
public class WallType {
    @Id
    @Column(name = "WALL_TYPE")
    private String wallType;
}
