package com.legalsight.exam.speechapi.model.mapper;

import com.legalsight.exam.speechapi.model.SubjectArea;
import com.legalsight.exam.speechapi.model.dto.SubjectAreaDto;
import org.springframework.stereotype.Component;

@Component
public class SubjectAreaMapperImpl implements SubjectAreaMapper{
    @Override
    public SubjectArea toSubjectArea(SubjectAreaDto subjectAreaDto) {
        SubjectArea subjectArea = new SubjectArea();
        subjectArea.setKeyword(subjectAreaDto.getKeyword());
        return subjectArea;
    }

    @Override
    public SubjectAreaDto fromSubjectArea(SubjectArea subjectArea) {
        SubjectAreaDto subjectAreaDto = new SubjectAreaDto();
        subjectAreaDto.setKeyword(subjectArea.getKeyword());
        return subjectAreaDto;
    }
}
