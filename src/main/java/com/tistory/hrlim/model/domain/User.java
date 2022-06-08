package com.tistory.hrlim.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    private String id;

    private String password;

    private String name;

    @OneToOne(mappedBy = "user")
    @ToString.Exclude
    private Calendar calendar;

}
