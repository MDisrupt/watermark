package com.mdisrupt.watermark.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/watermark")
@Slf4j
public class UploadService {
  @Autowired
  public UploadService() {}

  /** Uploads a file to the server to be watermarked and stored with the other watermarked files. */
  @PostMapping("/upload")
  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
    log.info("file uploaded!");
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
