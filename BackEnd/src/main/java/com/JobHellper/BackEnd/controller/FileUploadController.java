// FileUploadController.java
package com.JobHellper.BackEnd.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.JobHellper.BackEnd.services.Resume;
// import com.JobHellper.BackEnd.services.ResumeScanner;

@RestController
@RequestMapping("/api/files")
// Allow requests from the React app's origin (e.g., http://localhost:3000)
@CrossOrigin(origins = "http://localhost:5173") 
public class FileUploadController {
    private final Resume resume;
  private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    public FileUploadController(Resume resume) {
        this.resume = resume;
    }
    // private final String UPLOAD_DIR = "D:\\JobHelpper\\BackEnd\\src\\main\\java\\com\\jobhellper\\backend\\uploadFile";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Check if the file is empty
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        try {
            resume.setResume(file);
            resume.extract();
//             System.out.println("File received in controller: " + new String(file.
// getBytes()));
        try {
           logger.info("Received file: {}", file.getOriginalFilename());
            logger.info("File content type: {}", file.getContentType());
            logger.info("File size: {} bytes", file.getSize());

            // Read and print file content (assuming it's a text file)
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            // logger.info("File Content:\n{}", fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());

        } catch (Exception e) {
          return ResponseEntity.status(500).body("Could not upload the file: " + e.getMessage());
        }
    }
}