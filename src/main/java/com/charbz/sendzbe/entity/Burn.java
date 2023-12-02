package com.charbz.sendzbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BURNS")
public class Burn {
    @Id
    @Column(name = "BURN_NUMBER")
    private String burnNumber;

    @Column(name = "SORT_ID")
    private int sortId;
}
