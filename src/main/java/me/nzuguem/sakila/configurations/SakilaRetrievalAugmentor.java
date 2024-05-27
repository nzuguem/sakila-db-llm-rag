package me.nzuguem.sakila.configurations;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.query.Metadata;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SakilaRetrievalAugmentor implements RetrievalAugmentor {
    
    private final RetrievalAugmentor retrievalAugmentor;

    public SakilaRetrievalAugmentor(SakilaContentRetriever contentRetriever) {
        this.retrievalAugmentor = DefaultRetrievalAugmentor.builder()
                .contentRetriever(contentRetriever)
                .build();
    }

    @Override
    public UserMessage augment(UserMessage userMessage, Metadata metadata) {
        return this.retrievalAugmentor.augment(userMessage, metadata);
    }
}