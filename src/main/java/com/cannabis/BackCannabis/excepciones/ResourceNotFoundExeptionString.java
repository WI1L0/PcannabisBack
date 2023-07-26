package com.cannabis.BackCannabis.excepciones;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeptionString extends  RuntimeException{

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private String valorDelCampo;

    public ResourceNotFoundExeptionString(String nombreDelRecurso, String nombreDelCampo, String valorDelCampo) {
        super(String.format("%s No encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

}
