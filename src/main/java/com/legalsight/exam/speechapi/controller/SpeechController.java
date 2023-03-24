package com.legalsight.exam.speechapi.controller;

import com.legalsight.exam.speechapi.model.Speech;
import com.legalsight.exam.speechapi.model.SubjectArea;
import com.legalsight.exam.speechapi.model.dto.SpeechDto;
import com.legalsight.exam.speechapi.service.SpeechService;
import com.legalsight.exam.speechapi.service.SubjectAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/speech")
public class SpeechController {
    @Autowired
    private SpeechService speechService;
    @Autowired
    private SubjectAreaService subjectAreaService;
    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SpeechDto addNewSpeech(@RequestBody SpeechDto speechDto){

        SpeechDto savedSpeech = speechService.addNewSpeech(speechDto);
        return  savedSpeech;
    }

    @GetMapping(path = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<SpeechDto> getAllSpeech(){
        return speechService.getAllSpeech();
    }

    @PutMapping(path = "/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpeechDto editSpeech(@PathVariable Long id, @RequestBody SpeechDto speechDto) throws Exception {
    return speechService.editSpeech(id, speechDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpeechDto deleteSpeech(@PathVariable Long id) throws Exception {
        return speechService.deleteSpeech(id);
    }

    @GetMapping(path = "/searchBy")
    @ResponseStatus(HttpStatus.OK)
    public List<SpeechDto> searchByFilters(@RequestBody SpeechDto speechDto){
        return speechService.searchByFilter(speechDto);
    }

}
