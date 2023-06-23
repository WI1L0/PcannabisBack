package com.cannabis.BackCannabis.uploads;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UploadController {
    private static String DIRECTORY = "uploads";
    private static final long MAX_IMAGE_SIZE = 1024000;

    @PostMapping("/subir")
    public void uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        if (image.getSize() > MAX_IMAGE_SIZE) {
            throw new RuntimeException("La imagen es demasiado grande. El tamaño máximo permitido es de " + MAX_IMAGE_SIZE + " bytes.");
        }
        byte[] bytes = image.getBytes();
        Path path = Paths.get(DIRECTORY + "/" + image.getOriginalFilename());
        Files.write(path, bytes);
    }


    @GetMapping("/images/{imageName}")
    public byte[] getImagen(@PathVariable String imageName) throws IOException {
        Path path = Paths.get(DIRECTORY + "/" + imageName);
        return Files.readAllBytes(path);
    }
}
