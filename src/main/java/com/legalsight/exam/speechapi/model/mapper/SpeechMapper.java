package com.legalsight.exam.speechapi.model.mapper;

import com.legalsight.exam.speechapi.model.Speech;
import com.legalsight.exam.speechapi.model.dto.SpeechDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface SpeechMapper {
    SpeechMapper MAPPER = Mappers.getMapper( SpeechMapper.class );

    @Mapping(source = "title", target = "title")
//    @Mapping(source = "keywords", target = "subjectArea")
    Speech toSpeech(SpeechDto speechDto) ;

    @InheritInverseConfiguration
    SpeechDto fromSpeech(Speech speech);
}
