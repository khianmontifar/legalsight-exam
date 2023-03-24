package com.legalsight.exam.speechapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String author;
    private LocalDate date;
    @OneToMany
    private Collection<SubjectArea> subjectArea;

    @Override
    public String toString() {
        return "Speech{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", subjectArea=" + subjectArea +
                '}';
    }
}
