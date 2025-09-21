package com.jobhellper.backend.services;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.stereotype.Service;

@Service
public class ResumeScanner {
    private MultipartFile file;
    public void scanResume(void)
    {

    }
    public void scanResume(MultipartFile file){
        this.file = file;
        // System.out.println("File received in service: " + file.getOriginalFilename());
    }
    public MultipartFile getFile(){
        return file;
    }
    public void setFile(MultipartFile file){
        this.file = file;
    }
    void scanResume(){
        
    }

}
