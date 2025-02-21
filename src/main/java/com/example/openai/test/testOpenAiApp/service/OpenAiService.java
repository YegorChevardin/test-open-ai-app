package com.example.openai.test.testOpenAiApp.service;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final ChatModel chatModel;
    private final Faker faker;

    @Value("classpath:openai/templates/base_question_template.st")
    private Resource baseQuestionFileResource;

    @Value("${application.ai.mock.enabled}")
    private Boolean isMocked;

    public String getPromptResponse(String request) {
        if (isMocked) {
            return getMockedResponse();
        }

        var promptTemplate = new PromptTemplate(baseQuestionFileResource);
        var prompt = promptTemplate.create(
                Map.of("language", request));

        var chatResponse = chatModel.call(prompt);

        return chatResponse.getResult().getOutput().getContent();
    }

    private String getMockedResponse() {
        return faker.lorem().sentence();
    }
}
