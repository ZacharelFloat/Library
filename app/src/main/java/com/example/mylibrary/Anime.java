package com.example.mylibrary;

public class Anime {
    private int idAnime;
    private String nameAnime;
    private String releaseYear;
    private String studio;

    public Anime(int id, String name, String releaseYear, String studio) {
        this.idAnime = id;
        this.nameAnime = name;
        this.releaseYear = releaseYear;
        this.studio = studio;
    }

    public int getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(int idAnime) {
        this.idAnime = idAnime;
    }

    public String getNameAnime() {
        return nameAnime;
    }

    public void setNameAnime(String nameAnime) {
        this.nameAnime = nameAnime;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
