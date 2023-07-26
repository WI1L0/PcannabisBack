package com.cannabis.BackCannabis.Controller.Imagenes;

import com.cannabis.BackCannabis.Services.Imagenes.IImagenesServices;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cbd/picture")
@AllArgsConstructor
public class MediaController {

    private final IImagenesServices storageServicio;
    private final HttpServletRequest request;

    @PostMapping("/save")
    public Map<String, String> uploadFileOne (@RequestParam("file")MultipartFile multipartFile) {
        String path = storageServicio.save(multipartFile);
        return Map.of("url", path);
    }

    @GetMapping("/findOne/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageServicio.findOne(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }

}
