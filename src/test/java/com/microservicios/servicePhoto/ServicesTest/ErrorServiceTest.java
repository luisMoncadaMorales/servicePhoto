package com.microservicios.servicePhoto.ServicesTest;

import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Services.ErrorServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@SpringBootTest
public class ErrorServiceTest {
    @InjectMocks
    private ErrorServiceImp service;
    private Photo photo;
    private BindingResult bindingResult;
    @BeforeEach
    public void setup(){
        String paramName = "number_id";
        bindingResult = new BeanPropertyBindingResult(photo, paramName);
        bindingResult.addError(new ObjectError(paramName, "Payload value must not be empty"));
    }
    @Test
    public void formatMessage() {
        String result=service.formatMessage(bindingResult);
        Assertions.assertThat(result).isEqualTo("{\"statusCode\":\"01\",\"messages\":[]}");
    }
}
