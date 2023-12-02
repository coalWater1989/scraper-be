package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "HOLD_TYPES")
public class HoldType {
    @Id
    @Column(name = "HOLD_TYPE")
    private String holdType;
}
