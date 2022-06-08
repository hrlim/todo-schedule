package com.tistory.hrlim.model.domain.common;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class File{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String streCours;

    private String savedName;

    private boolean orignlName;

}
