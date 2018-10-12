package com.hniu.controllerAdvice;

import com.hniu.entity.wrap.State;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({BindException.class})
    @ResponseBody
    public Object bindException(BindException e) {
        String message = "";
        System.out.println(e.getModel());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        for (ObjectError error : errors) {
            message += error.getDefaultMessage()+" ";
        }
        return new State("1", message, null);
    }
}
