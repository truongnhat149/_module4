package vn.model;

public class EmailSettings {
    private String languages;
    private int size;
    private boolean spams_filter;
    private String signuature;

    public EmailSettings() {}

    public EmailSettings(String languages, int size, boolean spams_filter, String signuature) {
        this.languages = languages;
        this.size = size;
        this.spams_filter = spams_filter;
        this.signuature = signuature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpams_filter() {
        return spams_filter;
    }

    public void setSpams_filter(boolean spams_filter) {
        this.spams_filter = spams_filter;
    }

    public String getSignuature() {
        return signuature;
    }

    public void setSignuature(String signuature) {
        this.signuature = signuature;
    }
}
