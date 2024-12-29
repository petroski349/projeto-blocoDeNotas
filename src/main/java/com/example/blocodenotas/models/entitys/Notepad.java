package com.example.blocodenotas.models.entitys;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "notepad")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "number_words")
    private int numberWords;
    @Column(name = "information")
    private String information;
    @Column(name = "criation_date")
    private LocalDateTime criationDate;
    @Column(name = "modification_date")
    private LocalDateTime modificationDate;
    @Column(name = "user_id")
    private Long user;
    public Notepad() {
        this.criationDate = LocalDateTime.now();
    }

    public Notepad(Long user) {
        this.user = user;
        this.criationDate = LocalDateTime.now();
        this.numberWords = 0;
        this.title = null;
        this.information = null;
        this.modificationDate = null;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(int numberWords) {
        this.numberWords = numberWords;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public LocalDateTime getCriationDate() {
        return criationDate;
    }

    public void setCriationDate(LocalDateTime criationDate) {
        this.criationDate = criationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
