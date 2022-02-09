package com.mdisrupt.watermark.service;

import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WatermarkService {

  @Autowired
  public WatermarkService() {}

  /**
   * Applies the logo watermark to a file, and saves it.
   *
   * @param file An inputstream to a PDF.
   * @return The path of the file that was saved.
   * @throws IOException
   */
  public String watermark(InputStream file) throws IOException {
    return "not implmented";
  }
}
