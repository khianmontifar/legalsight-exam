package com.legalsight.exam.speechapi.model.mapper;

import com.legalsight.exam.speechapi.model.SubjectArea;
import com.legalsight.exam.speechapi.model.dto.SubjectAreaDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface SubjectAreaMapper {
    SubjectArea toSubjectArea(SubjectAreaDto subjectAreaDto);

    SubjectAreaDto fromSubjectArea(SubjectArea subjectArea);
}
