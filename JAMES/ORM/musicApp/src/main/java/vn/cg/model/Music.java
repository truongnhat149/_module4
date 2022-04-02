package vn.cg.model;

import javax.persistence.*;

@Entity
@Table(name= "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameSong;
    private String singer;
    private String category;
    private String sound;

    public Music() {}

    public Music(int id, String nameSong, String singer, String category, String sound) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
        this.sound = sound;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
