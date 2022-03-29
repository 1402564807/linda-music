package com.linda.lindamusic.entity;

import com.linda.lindamusic.enums.ArtistStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 艺术家
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Artist extends TraceableBaseEntity {

    private String name;

    private String remark;

    @OneToOne(cascade = CascadeType.PERSIST)
    private File photo;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;

    private ArtistStatus status;
}