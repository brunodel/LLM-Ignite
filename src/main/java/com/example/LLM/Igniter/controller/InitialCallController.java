package com.example.LLM.Igniter.controller;

import com.example.LLM.Igniter.repository.AnimalDao;
import com.example.LLM.Igniter.service.InitialCallService;
import com.example.LLM.Igniter.service.OpenAIService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.LLM.Igniter.util.Util.generateRandomNumber;

@RestController
@RequestMapping("/v1/llm")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InitialCallController {

    InitialCallService initialCallService;

    AnimalDao animalDao;


    @GetMapping("/initial-call")
    public ResponseEntity<String> makeInitialCall() throws Exception {

        log.info("Initial-call request");
        //log.info(response);
        String response = initialCallService.createInitialPrompt();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/get-animal")
//    public ResponseEntity<String> getAnimal() throws Exception {
//
//        //log.info(response);
//        String animal = animalDao.getAnimal(generateRandomNumber());
//
//        return new ResponseEntity<>(animal, HttpStatus.OK);
//    }

}
