package com.jecyhw.config.recognition;

import com.jecyhw.core.file.LocalFile;
import com.jecyhw.core.recognition.RecognitionTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jecyhw on 16-11-29.
 */

@Configuration
@EnableConfigurationProperties(RecognitionProperties.class)
public class RecognitionConfig {
    private final RecognitionProperties recognitionProperties;

    public RecognitionConfig(RecognitionProperties recognitionProperties) {
        this.recognitionProperties = recognitionProperties;
    }

    @Bean
    public RecognitionTemplate recognitionTemplate() {
        return new RecognitionTemplate(recognitionProperties.getPyPath());
    }

    @Bean
    public LocalFile localFile() {
        return new LocalFile(recognitionProperties.getUploadPath());
    }
}
