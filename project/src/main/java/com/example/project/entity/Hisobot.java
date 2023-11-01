package com.example.project.entity;

import com.example.project.entity.model.KelganVaqt;
import com.example.project.entity.model.KetganVaqt;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "hisobot")
@Builder
public class Hisobot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long kun;

    @OneToOne
    Xodim xodim;

    LocalDateTime kelishvaqti;

    LocalDateTime ketishvaqti;








}
