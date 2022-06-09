package com.tistory.hrlim.model.domain.common;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class File{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "stre_cours")
    private String storagePath;

    private String savedName;

    @Column(name = "orignl_name")
    private boolean originalName;

}
