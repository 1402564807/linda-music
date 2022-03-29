package com.linda.lindamusic.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * 角色
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Getter
@Setter
@Entity
@ToString
public class Role extends BaseEntity {
    private String name;

    private String title;
}
