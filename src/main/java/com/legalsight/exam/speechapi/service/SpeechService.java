package com.legalsight.exam.speechapi.service;

import com.legalsight.exam.speechapi.model.Speech;
import com.legalsight.exam.speechapi.model.SubjectArea;
import com.legalsight.exam.speechapi.model.dto.SpeechDto;
import com.legalsight.exam.speechapi.model.mapper.SpeechMapper;
import com.legalsight.exam.speechapi.model.mapper.SubjectAreaMapperImpl;
import com.legalsight.exam.speechapi.repository.SpeechRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SpeechService {
    @Autowired
    SpeechRepository speechRepository;

    @Autowired
    private SubjectAreaService subjectAreaService;

    @Autowired
    private SubjectAreaMapperImpl subjectAreaMapper;

    public SpeechDto addNewSpeech(SpeechDto speechDto){
        log.info("Param SpeechDTO: ",speechDto);
        Speech newSpeech = SpeechMapper.MAPPER.toSpeech( speechDto );
        log.info("NewSpeech: ",newSpeech);
        Optional<Speech> speech = speechRepository.findByTitleAndAuthor(speechDto.getTitle(), speechDto.getAuthor());
        if(speech.isPresent()){
            return SpeechMapper.MAPPER.fromSpeech( speech.get() );
        }
        List<SubjectArea> savedSubjectAreas=subjectAreaService.addNewSubjectAreas(speechDto.getKeywords());
        newSpeech.setSubjectArea(savedSubjectAreas);
        newSpeech =  speechRepository.save(newSpeech);
        SpeechDto returnDto = SpeechMapper.MAPPER.fromSpeech( newSpeech);
        returnDto.setKeywords(newSpeech.getSubjectArea().stream().map(a->a.getKeyword()).collect(Collectors.toList()));
        return returnDto;
    }

    public List<SpeechDto> getAllSpeech(){

        List<Speech> speechList = new ArrayList<>();
        speechRepository.findAll().forEach(speechList::add);
        return speechList.stream()
                .map(a->{
                    SpeechDto dto = SpeechMapper.MAPPER.fromSpeech( a );
                    dto.setKeywords(a.getSubjectArea().stream().map(z->z.getKeyword()).collect(Collectors.toList()));
                            return dto;
                })
                                .collect(Collectors.toList());
    }

    public SpeechDto editSpeech(Long id, SpeechDto newSpeech) throws Exception{
        Speech speech = speechRepository.findById(id).orElseThrow(()->new RuntimeException("Record does not exist."));
        speech.setAuthor(newSpeech.getAuthor()==null?speech.getAuthor(): newSpeech.getAuthor());
        speech.setBody(newSpeech.getBody()==null? speech.getBody() : newSpeech.getBody());
        speech.setDate(newSpeech.getDate()==null?speech.getDate():newSpeech.getDate());
        speech.setTitle(newSpeech.getTitle()==null? speech.getTitle() : newSpeech.getTitle());
        if(newSpeech.getKeywords()!=null && newSpeech.getKeywords().size()>0){
            speech.setSubjectArea(subjectAreaService.addNewSubjectAreas(newSpeech.getKeywords()));
        }else{
            speech.setSubjectArea(speech.getSubjectArea());
        }
        SpeechDto returnSpeechDto = SpeechMapper.MAPPER.fromSpeech( speechRepository.save(speech) );
        returnSpeechDto.setKeywords(speech.getSubjectArea().stream().map(a->a.getKeyword()).collect(Collectors.toList()));
        return  returnSpeechDto;
    }

    public SpeechDto deleteSpeech(Long id){
        Speech speech = speechRepository.findById(id).orElseThrow(()->new RuntimeException("Record does not exist."));
        speechRepository.delete(speech);
        return SpeechMapper.MAPPER.fromSpeech( speech );
    }

    public List<SpeechDto> searchByFilter(SpeechDto speechDto){
            List<Speech> speechList=speechRepository.findAll(Example.of(SpeechMapper.MAPPER.toSpeech( speechDto )));
        return speechList.stream().map(speech -> SpeechMapper.MAPPER.fromSpeech( speech )).collect(Collectors.toList());

    }


}
