package com.cannabis.BackCannabis.Imagenes.Services;

import com.cannabis.BackCannabis.Imagenes.Modelos.Asset;
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.BlobId;
//import com.google.cloud.storage.BlobInfo;
//import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

//@Service
public class ImagenesService {
//    public final static String BUCKET_NAME = "imagenes-cannabis";
//
//    @Autowired
//    private Storage storage;
//
//    public String putObject(MultipartFile file) {
//        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
//        String key = String.format("%s.%s", UUID.randomUUID(), extension);
//
//        try {
//            BlobId blobId = BlobId.of(BUCKET_NAME, key);
//            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
//            byte[] fileContent = file.getBytes();
//            Blob blob = storage.create(blobInfo, fileContent);
//
//            return key;
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    public Asset getObject(String key) {
//        BlobId blobId = BlobId.of(BUCKET_NAME, key);
//        Blob blob = storage.get(blobId);
//
//        byte[] fileContent = blob.getContent();
//        String contentType = blob.getContentType();
//        return new Asset(fileContent, contentType);
//    }
//
//    public void deleteObject(String key) {
//        BlobId blobId = BlobId.of(BUCKET_NAME, key);
//        storage.delete(blobId);
//    }
//
//    public String getObjectUrl(String key) {
////        https://console.cloud.google.com/storage/browser/imagenes-cannabis
//        return String.format("https://storage.googleapis.com/%s/%s", BUCKET_NAME, key);
//    }
}