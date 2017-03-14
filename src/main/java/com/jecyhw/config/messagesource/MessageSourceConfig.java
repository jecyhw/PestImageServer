package com.jecyhw.config.messagesource;

import com.jecyhw.core.validation.ValidationMessageCodeResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by jecyhw on 16-11-9.
 */
@Configuration
public class MessageSourceConfig {

    @Bean
    public ValidationMessageCodeResolver validationMessageCodeResolver(MessageSource messageSource) {
        return new ValidationMessageCodeResolver(messageSource);
    }
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setBasenames("i18n/messages");
        return resourceBundleMessageSource;
    }
}
