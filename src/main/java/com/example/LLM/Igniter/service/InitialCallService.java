package com.example.LLM.Igniter.service;

import com.example.LLM.Igniter.repository.AnimalDao;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.LLM.Igniter.util.Util.generateRandomNumber;
import static com.example.LLM.Igniter.util.Util.getInitialPromptFormat;

@Service
@RequiredArgsConstructor
@Slf4j
public class InitialCallService {

    private final OpenAIService openAIService;

    private final AnimalDao animalDao;

    @Value("${string-to-replace-by-animal}")
    private String stringToReplaceByAnimal;

    public String createInitialPrompt() throws Exception {

        //log.info(response);
        int randomNumber = generateRandomNumber();

        String animal = animalDao.getAnimal(randomNumber);

//        String initialPrompt = getInitialPromptFormat().replace(stringToReplaceByAnimal, animal);
//
//        String response = openAIService.createOpenAiRequest(initialPrompt);
//
//        log.info(response);

        return animal;
    }

}
