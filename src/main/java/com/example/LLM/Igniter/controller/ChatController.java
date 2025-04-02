package com.example.LLM.Igniter.controller;

import com.example.LLM.Igniter.model.ChatMessageDTO;
import com.example.LLM.Igniter.service.OpenAIService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/llm")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ChatController {

    OpenAIService openAIService;


    @PostMapping("/chat")
    public ResponseEntity<String> gameApi(@RequestBody ChatMessageDTO chatMessageDTO) throws Exception {

        log.info("Chat call received: Animal={}, userChatMessage={}, id={}",
                chatMessageDTO.getAnimal(),
                chatMessageDTO.getUserChatMessage(),
                chatMessageDTO.getId());

        String response = openAIService.createOpenAiRequest(chatMessageDTO);
        log.info(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
