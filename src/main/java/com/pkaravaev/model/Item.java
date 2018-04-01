package com.pkaravaev.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;
    @Column(name = "publish_date")
    private Date publishDate;

    private String link;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @ManyToOne
    @JoinColumn(table ="blog_id")
    private Blog blog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
