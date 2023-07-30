package com.cannabis.BackCannabis.Imagenes.Controller;

import com.cannabis.BackCannabis.Imagenes.Modelos.Asset;
import com.cannabis.BackCannabis.Imagenes.Services.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//@RestController
//@RequestMapping("/cbd/pictures")
public class ImagenesController {

//    @Autowired
//    private ImagenesService imagenesService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        String key = imagenesService.putObject(file);
//        String url = imagenesService.getObjectUrl(key);
//
//        return new ResponseEntity<>(url, HttpStatus.OK);
//    }
//
//    @GetMapping("/download/{key}")
//    public ResponseEntity<Asset> downloadFile(@PathVariable String key) {
//        Asset asset = imagenesService.getObject(key);
//
//        return ResponseEntity.ok()
//                .header("Content-Disposition", "attachment; filename=\"" + key + "\"")
//                .body(asset);
//    }
//
//    @DeleteMapping("/delete/{key}")
//    public ResponseEntity<Void> deleteFile(@PathVariable String key) {
//        imagenesService.deleteObject(key);
//
//        return ResponseEntity.noContent().build();
//    }
}