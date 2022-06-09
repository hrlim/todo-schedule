package com.tistory.hrlim.model.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Memo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Calendar calendar;

    private LocalTime expiredMonth;

    private String content;
}
