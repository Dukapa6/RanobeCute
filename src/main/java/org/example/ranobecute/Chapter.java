package org.example.ranobecute;

public class Chapter {
    private int idchapters;
    private int novel_id;
    private int volume_number;
    private int chapter_number;
    private String title;
    private String pathtext;


    public Chapter() {
    }

    public Chapter(int novel_id, int volume_number, int chapter_number, String title, String pathtext) {
        this.novel_id = novel_id;
        this.volume_number = volume_number;
        this.chapter_number = chapter_number;
        this.title = title;
        this.pathtext = pathtext;
    }

    public int getIdchapters() {
        return idchapters;
    }

    public void setIdchapters(int idchapters) {
        this.idchapters = idchapters;
    }

    public int getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(int novel_id) {
        this.novel_id = novel_id;
    }

    public int getVolume_number() {
        return volume_number;
    }

    public void setVolume_number(int volume_number) {
        this.volume_number = volume_number;
    }

    public int getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(int chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPathtext() {
        return pathtext;
    }

    public void setPathtext(String pathtext) {
        this.pathtext = pathtext;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "idchapters=" + idchapters +
                ", novel_id=" + novel_id +
                ", volume_number=" + volume_number +
                ", chapter_number=" + chapter_number +
                ", title='" + title + '\'' +
                ", pathtext='" + pathtext + '\'' +
                '}';
    }

}
