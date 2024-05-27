package me.nzuguem.sakila.services;


import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface RequestSakilaService {
    
    String request(@UserMessage String prompt);
}