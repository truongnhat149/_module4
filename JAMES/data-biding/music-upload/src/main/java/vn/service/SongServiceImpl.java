package vn.service;

import vn.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements ISongService {

    private static List<Song> songs;

    static {
        songs = new ArrayList<>();
        songs.add(new Song(1, "Yeu La cuoi", "Phat Ho", "OK","Yeu-La-Cuoi-Phat-Ho-X2X.mp3"));
        songs.add(new Song(2, "Tieng Goi Noi Anh", "Chi Dan", "Good", "Tieng-Goi-Noi-Anh-Chi-Dan.mp3"));
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }

    @Override
    public void update(int id, Song song) {
        for (Song s : songs) {
            if (s.getId() == id) {
                s = song;
                break;
            }
        }
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < songs.size(); i++){
            if (songs.get(i).getId() == id) {
                songs.remove(i);
            }
        }
    }
}
