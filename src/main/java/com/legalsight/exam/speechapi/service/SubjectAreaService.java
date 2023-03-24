package com.legalsight.exam.speechapi.service;

import com.legalsight.exam.speechapi.model.SubjectArea;
import com.legalsight.exam.speechapi.model.dto.SubjectAreaDto;
import com.legalsight.exam.speechapi.repository.SubjectAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectAreaService {
    @Autowired
    private SubjectAreaRepository subjectAreaRepository;
    public List<SubjectArea> addNewSubjectAreas(List<String> keywords){
        return subjectAreaRepository.saveAll(keywords.stream().map(a->{
                    SubjectArea subjectArea = new SubjectArea();
                    subjectArea.setKeyword(a);
                    Optional<SubjectArea> subArea = subjectAreaRepository.findByKeyword(a);
                    if(!subArea.isPresent()){
                        subjectArea = subjectAreaRepository.save(subjectArea);
                    }
                    return subjectArea;
                }
        ).collect(Collectors.toList()));
    }
}
