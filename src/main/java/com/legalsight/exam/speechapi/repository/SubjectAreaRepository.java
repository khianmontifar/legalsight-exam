package com.legalsight.exam.speechapi.repository;

import com.legalsight.exam.speechapi.model.SubjectArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubjectAreaRepository extends JpaRepository<SubjectArea,Long> {
    Optional<SubjectArea> findByKeyword(String keyword);
}
