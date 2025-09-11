package com.example.HexagonalStudy.adapter.out.persistence;

import com.example.HexagonalStudy.domain.model.Post;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class JpaPostEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String author;

    protected JpaPostEntity() {}

    public JpaPostEntity(Long id, String title, String content, String author) {
        this.id = id; this.title = title; this.content = content; this.author = author;
    }

    public static JpaPostEntity fromDomain(Post p) {
        return new JpaPostEntity(p.getId(), p.getTitle(), p.getContent(), p.getAuthor());
    }

    public Post toDomain() {
        return new Post(id, title, content, author);
    }

    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getContent() {return content;}
    public String getAuthor() {return author;}
    public void setId(Long id) { this.id = id;}
    public void setTitle(String t) {this.title = title;}
    public void setContent(String c) { this.content = content;}
    public void setAuthor(String a) {this.author = author;}
}
