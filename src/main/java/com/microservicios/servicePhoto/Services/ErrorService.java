package com.microservicios.servicePhoto.Services;

import org.springframework.validation.BindingResult;

public interface ErrorService {
    String formatMessage(BindingResult bindingResult);
}
