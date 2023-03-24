package com.legalsight.exam.speechapi.model.dto;

import com.legalsight.exam.speechapi.model.SubjectArea;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SpeechDto {
    private String title;
    private String body;
    private String author;
    private LocalDate date;
    private List<String> keywords;

    @Override
    public String toString() {
        return "SpeechDto{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", keywords=" + keywords +
                '}';
    }
}
