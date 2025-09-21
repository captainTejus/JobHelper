// FileUploadController.java
package com.jobhellper.backend.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.atmosphere.config.service.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jobhellper.backend.services.NumberServices;
import com.jobhellper.backend.services.ResumeScanner;

@RestController
@RequestMapping("/api/files")
// Allow requests from the React app's origin (e.g., http://localhost:3000)
@CrossOrigin(origins = "http://localhost:5173") 
public class FileUploadController {
    private final ResumeScanner resumeScanner;

    @Autowired
    public FileUploadController(ResumeScanner resumeScanner) {
        this.resumeScanner = resumeScanner;
    }
    // Define the path where uploaded files will be stored.
    // NOTE: In a real application, you should make this path configurable.
    // private final String UPLOAD_DIR = "D:\\JobHelpper\\BackEnd\\src\\main\\java\\com\\jobhellper\\backend\\uploadFile";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Check if the file is empty
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        try {
            resumeScanner.setFile(file);
            resumeScanner.scanResume();
            /////////////////////////////////////////////////////////////////////////////////////////////
//             StringBuilder resultStringBuilder = new StringBuilder();
//         try (InputStreamReader reader = new InputStreamReader(file.
// getInputStream(), StandardCharsets.UTF_8)) {
//             int data = reader.read();
//             while (data != -1) {
//                 resultStringBuilder.append((char) data);
//                 data = reader.read();
//             }
//         }
            // Return a success response
            return ResponseEntity.ok("File uploaded successfully: " + file.getName());

        } catch (Exception e) {
            // System.out.println(e.getMessage()+"error");
            // Return an error response if something goes wrong
            return ResponseEntity.status(500).body("Could not upload the file: " + e.getMessage());
        }
    }
}