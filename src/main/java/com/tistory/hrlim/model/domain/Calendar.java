package com.tistory.hrlim.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Calendar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 반드시 존재함 , null 허용하지 않음 (optional = false)
    @OneToOne(optional = false)
    private User user;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "calendar_id", insertable = false, updatable = false)
    private List<Memo> todos = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "calendar_id", insertable = false, updatable = false)
//    private List<Todo> memos = new ArrayList<>();

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "calendar_id", insertable = false, updatable = false)
//    private List<Schedule> schedules = new ArrayList<>();

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "calendar_id", insertable = false, updatable = false)
//    private List<DailyPlan> dailyPlans = new ArrayList<>();
}
