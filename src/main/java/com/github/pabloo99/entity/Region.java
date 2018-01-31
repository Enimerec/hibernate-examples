package com.github.pabloo99.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @Column(name = "region_id")
    private double regionId;

    @Column(name = "region_name")
    private String regionName;




}
