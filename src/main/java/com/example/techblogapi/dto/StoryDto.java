package com.example.techblogapi.dto;

import java.util.Date;

public class StoryDto {

    private int id;
    private String author;
    private String title;
    private String description;
    private Date CreatedDate;

    public StoryDto() {

    }

    public StoryDto(int id, String author, String title, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Date getCreatedDate() {

        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {

        CreatedDate = createdDate;
    }

}
