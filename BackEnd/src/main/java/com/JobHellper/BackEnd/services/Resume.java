package com.JobHellper.BackEnd.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Resume {
    private MultipartFile file;
    private MultipartFile decryptFile(MultipartFile file)
    {
        //return  decrypted file
        return file;
    }
    public void extract()
    {
        ///scan Resume either by OCR or raw data
    }
    public void setResume(MultipartFile file){
        file=decryptFile(file);
        this.file = file;
        // System.out.println("File received in service: " + file.getOriginalFilename());
    }
    protected MultipartFile getFile(){
        return file;
    }
    protected void setFile(MultipartFile file){
        this.file = file;
    }

}
