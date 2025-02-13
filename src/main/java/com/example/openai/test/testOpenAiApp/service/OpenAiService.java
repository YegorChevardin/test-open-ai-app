package com.example.openai.test.testOpenAiApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final ChatModel chatModel;

    @Value("${application.ai.mock.enabled}")
    private Boolean isMocked;

    public String getPromptResponse(String request) {
        if (isMocked) {
            return getMockedResponse();
        }

        var promptTemplate = new PromptTemplate(request);
        var prompt = promptTemplate.create();

        var chatResponse = chatModel.call(prompt);

        return chatResponse.getResult().getOutput().getContent();
    }

    private String getMockedResponse() {
        return
    }
}
