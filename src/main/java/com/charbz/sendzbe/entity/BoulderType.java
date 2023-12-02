package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BOULDER_TYPES")
public class BoulderType {
    @Id
    @Column(name = "BOULDER_TYPE")
    private String boulderType;
}
