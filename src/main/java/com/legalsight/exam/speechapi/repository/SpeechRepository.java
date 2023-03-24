package com.legalsight.exam.speechapi.repository;

import com.legalsight.exam.speechapi.model.Speech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpeechRepository extends JpaRepository<Speech, Long> {
    Optional<Speech> findByTitleAndAuthor(String title, String author);

}
