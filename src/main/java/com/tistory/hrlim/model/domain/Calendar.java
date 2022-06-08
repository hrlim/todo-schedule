package com.tistory.hrlim.model.domain;

import lombok.*;

import javax.persistence.*;

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
}
