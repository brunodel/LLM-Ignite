package com.example.LLM.Igniter.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static String objectToString(Object object) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        // Converter o objeto Java para JSON
        return objectMapper.writeValueAsString(object);
    }

    public static int generateRandomNumber() {
        // De 0 a 24
        return ThreadLocalRandom.current().nextInt(25);
    }

//    public static String getInitialPromptFormat() {
//        return "Vamos fazer assim, vamos jogar \"Quem Sou Eu?\" (ou \"Hedbanz\"), você só pode responder \"sim\", \"não\" ou \"não sei\". Eu vou passar o computador pra outra pessoa, e ela vai ter que adivinhar o animal.\n" +
//                "Os animais estão na lista a seguir:\n" +
//                "\n" +
//                "animal = [\"STRING_PARA_SUBSTITUIR\"]\n" +
//                "\n" +
//                "a partir de agora o jogo vai começar!";
//    }

    public static String getInitialPromptFormat() {
        return "Vamos fazer assim, vamos jogar \"Quem Sou Eu?\" (ou \"Hedbanz\"). Eu vou passar o computador pra outra pessoa, e ela vai ter que adivinhar o animal.\n" +
                "Os animais estão na lista a seguir:\n" +
                "\n" +
                "animal = [\"STRING_PARA_SUBSTITUIR\"]\n" +
                "\n" +
                "a partir de agora o jogo vai começar!";
    }
}
