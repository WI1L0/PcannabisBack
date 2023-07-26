package com.cannabis.BackCannabis.excepciones;

import com.cannabis.BackCannabis.Dtos.Defauld.ErrorDetallesDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExeptionLong.class)
    public ResponseEntity<ErrorDetallesDto> manejarResourceNotFoundExeptionLong(ResourceNotFoundExeptionLong exception, WebRequest webRequest){
        ErrorDetallesDto errorDetallesDto = new ErrorDetallesDto(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetallesDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundExeptionString.class)
    public ResponseEntity<ErrorDetallesDto> manejarResourceNotFoundExeptionString(ResourceNotFoundExeptionString exception, WebRequest webRequest){
        ErrorDetallesDto errorDetallesDto = new ErrorDetallesDto(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetallesDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogAppExeption.class)
    public ResponseEntity<ErrorDetallesDto> manejarBlogAppExeption(BlogAppExeption exception, WebRequest webRequest){
        ErrorDetallesDto errorDetallesDto = new ErrorDetallesDto(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetallesDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ImagenExeption.class)
    public ResponseEntity<ErrorDetallesDto> manejarImegenesExecption(ImagenExeption exception, WebRequest webRequest){
        ErrorDetallesDto errorDetallesDto = new ErrorDetallesDto(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetallesDto, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetallesDto> manejarGlobalExeption(Exception exception, WebRequest webRequest){
//        ErrorDetallesDto errorDetallesDto = new ErrorDetallesDto(new Date(), exception.getMessage(), webRequest.getDescription(false));
//        return new ResponseEntity<>(errorDetallesDto, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nombreCampo = ((FieldError)error).getField();
            String mensaje = error.getDefaultMessage();

            errores.put(nombreCampo, mensaje);
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
