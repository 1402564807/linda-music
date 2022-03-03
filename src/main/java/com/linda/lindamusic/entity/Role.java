package com.linda.lindamusic.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@ToString
public class Role extends AbstractEntity{
    private String name;

    private String title;
}
