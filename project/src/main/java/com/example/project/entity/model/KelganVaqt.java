package com.example.project.entity.model;

import com.example.project.entity.Xodim;
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
@Table(name = "kelganVaqt")
public class KelganVaqt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long kun;

    @OneToOne
    Xodim xodim;

    LocalDateTime kelganVaqt;
}
