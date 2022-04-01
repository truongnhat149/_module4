package vn.service;

import vn.model.Song;
import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    void update(int id, Song song);

    Song findById(int id);

    void remove(int id);
}
