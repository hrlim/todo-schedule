package com.tistory.hrlim.model.domain;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Calendar calendar;

    @NonNull
    private String title;

    @NonNull
    private LocalDate expiredMonth;

    private int important;

    private boolean completed;

}
