package com.tistory.hrlim.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ScheduleEntity {
    @Id
    private Long id;
}
