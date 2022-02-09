package com.mdisrupt.watermark.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Retrieves and manages files stored on the server. */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/watermark")
@Slf4j
public class FileService {
  @Autowired
  public FileService() {}

  @GetMapping()
  public ResponseEntity<List<String>> getAllFiles() {
    log.info("fetching files!");
    return new ResponseEntity<>(List.of("file1.pdf", "file2.pdf"), HttpStatus.OK);
  }
}
