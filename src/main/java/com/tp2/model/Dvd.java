package com.tp2.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Dvd extends Document {
    private int duree;
}