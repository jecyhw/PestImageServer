package com.jecyhw.core.validation;

import com.jecyhw.core.util.ObjectUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jecyhw on 16-11-2.
 */
final public class ValidationMessageCodeResolver {

    private MessageSource messageSource;

    public ValidationMessageCodeResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public List<SimpleFieldError> bindingResultToSimple(BindingResult bindingResult) {
        return fieldErrorsToSimple(bindingResult, bindingResult.getFieldErrors());
    }

    private List<SimpleFieldError> fieldErrorsToSimple(BindingResult bindingResult, List<FieldError> fieldErrors) {
        return fieldErrors.stream().map(fieldError -> fieldErrorToSimple(bindingResult, fieldError)).collect(Collectors.toList());
    }

    private SimpleFieldError fieldErrorToSimple(BindingResult bindingResult, FieldError fieldError) {
        SimpleFieldError simpleFieldError = new SimpleFieldError();
        String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode(), fieldError.getField());
        String code = resolveMessageCodes[0];
        String message;
        try {
            message = messageSource.getMessage(code, new Object[]{fieldError.getRejectedValue()}, ObjectUtils.nullObj());
        } catch (NoSuchMessageException e) {
            message = fieldError.getDefaultMessage();
        }
        simpleFieldError.setMessage(message);
        simpleFieldError.setField(fieldError.getField());
        return simpleFieldError;
    }
}

