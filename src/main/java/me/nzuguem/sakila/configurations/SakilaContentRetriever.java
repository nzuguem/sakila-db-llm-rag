package me.nzuguem.sakila.configurations;

import dev.langchain4j.experimental.rag.content.retriever.sql.SqlDatabaseContentRetriever;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SakilaContentRetriever implements ContentRetriever {

    // It's the Ollama one, because it's the only one integrated in Maven dependency.
    private final ChatLanguageModel chatLanguageModel;
    
    // Agroal datasource injection.
    private final AgroalDataSource dataSource;

    public SakilaContentRetriever(
            ChatLanguageModel chatLanguageModel,
            AgroalDataSource dataSource
    ) {
        this.chatLanguageModel = chatLanguageModel;
        this.dataSource = dataSource;
    }

    @Override
    public List<Content> retrieve(Query query) {
        
        return SqlDatabaseContentRetriever.builder()
                .dataSource(this.dataSource)
                .chatLanguageModel(this.chatLanguageModel)
                .build()
                .retrieve(query);
        
    }
}