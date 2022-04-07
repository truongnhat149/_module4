package lpnt.cg.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class Music implements Validator {


    private String nameSong;

    private String singer;

    private String sound;

    private String category;

    public Music() {}

    public Music(String nameSong, String singer, String sound, String category) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.sound = sound;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Music.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music = (Music) target;
        String nameSong = music.getNameSong();
        String singer = music.getSinger();
        String category = music.getCategory();

        ValidationUtils.rejectIfEmpty(errors, "nameSong", "nameSong.empty");

        if (nameSong.length() > 800) {
            errors.rejectValue("nameSong", "nameSong.length");
        }

        if (nameSong.matches("[@;,.=\\-+,…]*")) {
            errors.rejectValue("nameSong", "nameSong.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "singer", "singer.empty");
        if (singer.length() > 300) {
            errors.rejectValue("singer", "singer.length");
        }

        if(singer.matches("[@;,.=\\-+,…]*")) {
            errors.rejectValue("singer", "singer.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "category", "category.empty");

        if (category.length() > 1000) {
            errors.rejectValue("category", "category.length");
        }

        if (category.matches("[!@#\\$%\\^&*;'}{|]*")) {
            errors.rejectValue("category","category.matches");
        }
    }

}
