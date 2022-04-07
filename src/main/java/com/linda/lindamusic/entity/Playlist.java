package com.linda.lindamusic.entity;

import com.linda.lindamusic.enums.PlayListStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 播放列表
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Entity
@Getter
@Setter
@ToString
public class Playlist extends TraceableBaseEntity {
    private String name;

    private String description;
    @OneToOne
    private File cover;

    @Enumerated(EnumType.STRING)
    private PlayListStatus status = PlayListStatus.DRAFT;


    @ManyToMany
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    @ToString.Exclude
    private List<Music> musicList;

    private Boolean recommended = false;

    private Integer recommendFactor = 0;

    private Boolean special = false;
}