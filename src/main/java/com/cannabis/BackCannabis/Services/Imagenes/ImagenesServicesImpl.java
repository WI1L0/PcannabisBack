package com.cannabis.BackCannabis.Services.Imagenes;

import com.cannabis.BackCannabis.excepciones.ImagenExeption;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImagenesServicesImpl implements IImagenesServices {

    @Value("${media.location}")
    private String mediaLocation;

    private Path rootLocation;

    @Override
    @PostConstruct
    public void init() throws IOException {
        rootLocation = Paths.get(mediaLocation);
        Files.createDirectories(rootLocation);
    }

    @Override
    public String save(MultipartFile file) {
        try{
            if (file.isEmpty()){
                throw new ImagenExeption("No se pudo almacenar el archivo esta vacío.");
            }

            String filename = file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            return filename;

        } catch (IOException e) {
            throw new ImagenExeption("No se pudo almacenar el campo.");
        }
    }

    @Override
    public Resource findOne(String filename) {
        try{
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new ImagenExeption("No se pudo leer el archivo: " + filename);
            }
        } catch (MalformedURLException e){
            throw new ImagenExeption("No se pudo leer el archivo: " + filename);
        }
    }
}
