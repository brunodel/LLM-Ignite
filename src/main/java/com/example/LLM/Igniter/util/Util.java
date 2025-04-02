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

    public static String getInitialPromptFormat_antigo() {
        return "Vamos fazer assim, vamos jogar \"Quem Sou Eu?\" (ou \"Hedbanz\"). Eu vou passar o computador pra outra pessoa, e ela vai ter que adivinhar o animal.\n" +
                "Os animais estão na lista a seguir:\n" +
                "\n" +
                "animal = [\"STRING_PARA_SUBSTITUIR\"]\n" +
                "\n" +
                "a partir de agora o jogo vai começar!";
    }

    public static String getInitialPromptFormatWithPronptEng() {
        return "Vamos fazer assim, vamos jogar \"Quem Sou Eu?\" (ou \"Hedbanz\"). Eu vou passar o computador pra outra pessoa, e ela vai ter que adivinhar o animal.\n" +
                "Os animais estão na lista a seguir:\n" +
                "\n" +
                "Ele (o usuário) é um \"STRING_PARA_SUBSTITUIR\"\n" +
                "\n" +
                "Vou te dar alguns exemplos para você entender melhor (para o caso em que o usuário é um leão)\n" +
                "\n" +
                "USUÁRIO: Eu sou carnivoro?\n" +
                "\n" +
                "SUA RESPOSTA: Sim, você é carnivoro! Está no caminho certo.\n" +
                "\n" +
                "--\n" +
                "\n" +
                "USUÁRIO: Que animal eu sou?\n" +
                "\n" +
                "SUA RESPOSTA: Eu eu não posso te contar que animal você é. Continue tentando.\n" +
                "\n" +
                "--\n" +
                "\n" +
                "USUÁRIO: Eu sou grande ou pequeno?\n" +
                "\n" +
                "SUA RESPOSTA: Infelizmente eu só posso responder perguntas no estilo sim ou não. Você poderia perguntar: \"eu sou pequeno?\"\n" +
                "\n" +
                "--\n" +
                "\n" +
                "USUÁRIO: Meu animal é um leão?\n" +
                "\n" +
                "SUA RESPOSTA: Uhuuuu, você acertou!!! Seu animal é um leão <emoji de leão>. Parabéns!\"\n" +
                "\n" +
                "--\n" +
                "\n" +
                "USUÁRIO: Meu animal é um leão!\n" +
                "\n" +
                "SUA RESPOSTA: Uhuuuu, você acertou!!! Seu animal é um leão <emoji de leão>. Parabéns!\"\n" +
                "\n" +
                "-----\n" +
                "\n" +
                "A partir de agora o jogo vai começar!";
    }

}
