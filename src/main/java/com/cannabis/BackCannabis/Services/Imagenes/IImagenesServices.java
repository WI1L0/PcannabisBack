package com.cannabis.BackCannabis.Services.Imagenes;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImagenesServices {

    void init() throws IOException;

    public String save(MultipartFile file);

    Resource findOne(String filename);

}
