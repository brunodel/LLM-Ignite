package com.example.LLM.Igniter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenAIBody {

    private String model;

    // private String prompt;

    private int max_tokens;

    private Float temperature;

    private List<Map<String, String>> messages;

//    messages=[
//    {"role": "system", "content": "Você é um assistente útil."},
//    {"role": "user", "content": "Qual é a capital da França?"}
//    ],

}
