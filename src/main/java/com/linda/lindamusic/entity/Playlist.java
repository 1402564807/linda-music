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
public class Playlist extends BaseEntity {
    private String name;

    private String description;

    @OneToOne
    private File cover;

    @Enumerated(EnumType.STRING)
    private PlayListStatus status;

    @OneToOne
    private User creator;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;
}