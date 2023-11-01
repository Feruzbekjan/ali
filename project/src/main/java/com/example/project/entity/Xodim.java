package com.example.project.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "xodim")
public class Xodim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    Pasport pasport;

    Integer age;

    String manzili;

    @OneToOne
    Bolim bolim;

    @OneToOne
    Lavozim lavozim;

    Double maoshi;



}
