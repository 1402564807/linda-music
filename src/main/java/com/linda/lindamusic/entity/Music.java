package com.linda.lindamusic.entity;

import com.linda.lindamusic.enums.MusicStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 音乐
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Entity
@Getter
@Setter
@ToString
public class Music extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private MusicStatus status;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artistList;

    private String description;

    @OneToOne
    private File file;
}