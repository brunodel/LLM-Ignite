package com.example.LLM.Igniter.service;

import com.example.LLM.Igniter.model.ChatMessageDTO;
import com.example.LLM.Igniter.model.OpenAIBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.LLM.Igniter.util.Util.getInitialPromptFormat;
import static com.example.LLM.Igniter.util.Util.objectToString;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.max-tokens}")
    private int maxTokens;

    @Value("${openai.api.temperature}")
    private Float temperature;

    @Value("${string-to-replace-by-animal}")
    private String stringToReplaceByAnimal;

    private final RestTemplate restTemplate;

    public String createOpenAiRequest(ChatMessageDTO chatMessageDTO) throws Exception{
        log.info("Creating request to call Open AI");
        // Configura o cabeçalho com a chave da API
        HttpHeaders headers = createHeaders();

        // Corpo da requisição
        String requestBody = objectToString(createBody(chatMessageDTO));
        log.info("OPEN AI Request body: {}", requestBody);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Realiza a chamada para a API da OpenAI
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        // Retorna a resposta
        return response.getBody();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    private OpenAIBody createBody(ChatMessageDTO chatMessageDTO) {

        return new OpenAIBody(model,
                maxTokens,
                temperature,
                createMessages(chatMessageDTO));
    }

    private  List<Map<String, String>> createMessages(ChatMessageDTO chatMessageDTO) {
        String initialPrompt = getInitialPromptFormat().replace(stringToReplaceByAnimal, chatMessageDTO.getAnimal());

//        {"role": "system", "content": "Você é um assistente útil e amigável."}
        Map<String, String> map1 = Map.of("role", "system",
                "content", initialPrompt);

        Map<String, String> map2 = Map.of("role", "user",
                "content", chatMessageDTO.getUserChatMessage());


        List<Map<String, String>> messages = new ArrayList<>();

        messages.add(map1);
        messages.add(map2);

        return messages;
    }

}
