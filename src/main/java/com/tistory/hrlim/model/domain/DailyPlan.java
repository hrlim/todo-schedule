package com.tistory.hrlim.model.domain;

import com.tistory.hrlim.model.domain.common.File;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DailyPlan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Calendar calendar;

    private long categoryId;

    private LocalDate expiredMonth;

    private String plan;

    private boolean completed;

//    @OneToMany
//    private List<File> files;
}

