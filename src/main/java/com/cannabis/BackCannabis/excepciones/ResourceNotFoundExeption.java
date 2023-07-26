package com.cannabis.BackCannabis.excepciones;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends  RuntimeException{

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private long valorDelCampo;

    public ResourceNotFoundExeption(String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(String.format("%s No encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

}
