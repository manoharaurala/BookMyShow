package org.ruby.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.ruby.bookmyshow.models.enums.Feature;
import org.ruby.bookmyshow.models.enums.Language;

import java.util.List;

@Entity
@Setter
@Getter
public class Movie extends BaseModel {
    private String name;
    private String duration;
    private String genre;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Language> languages;
    private String releaseDate;
    @ElementCollection
    private List<String> actors;
    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
