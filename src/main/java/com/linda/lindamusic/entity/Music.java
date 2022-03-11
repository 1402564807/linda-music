package com.linda.lindamusic.entity;

import com.linda.lindamusic.enums.MusicStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@ToString
public class Music extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    private String description;

    @OneToOne
    private File file;
}