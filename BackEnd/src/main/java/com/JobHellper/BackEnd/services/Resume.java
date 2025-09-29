package com.JobHellper.BackEnd.services;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

// import javax.swing.*;
// import java.awt.*;
// import java.io.IOException;
@Service
public class Resume {


//  public static void displayFile(MultipartFile file) {
//         if (file == null || file.isEmpty()) {
//             JOptionPane.showMessageDialog(null, "File is empty or null.");
//             return;
//         }

//         SwingUtilities.invokeLater(() -> {
//             JFrame frame = new JFrame("File Viewer: " + file.getOriginalFilename());
//             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             frame.setSize(600, 400);

//             try {
//                 String contentType = file.getContentType();

//                 if (contentType != null && contentType.startsWith("image")) {
//                     // Display as an image
//                     ImageIcon imageIcon = new ImageIcon(file.getBytes());
//                     JLabel label = new JLabel(imageIcon);
//                     JScrollPane scrollPane = new JScrollPane(label);
//                     frame.add(scrollPane);
//                 } else {
//                     // Display as text
//                     String content = new String(file.getBytes());
//                     JTextArea textArea = new JTextArea(content);
//                     textArea.setEditable(false);
//                     JScrollPane scrollPane = new JScrollPane(textArea);
//                     frame.add(scrollPane);
//                 }

//             } catch (IOException e) {
//                 JOptionPane.showMessageDialog(frame, "Error reading file: " + e.getMessage());
//             }

//             frame.setVisible(true);
//         });
//     }
    
    //////////////////////////////////////
    // @Autowired
    private MultipartFile file;
    @Autowired
    private EncryptionService encryptionService;
    private MultipartFile decryptFile(MultipartFile file)
    {
        //return  decrypted file
        try {
            return encryptionService.decryptFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
    public void extract()
    {
        ///scan Resume either by OCR or raw data
    }
    public void setResume(MultipartFile file){
        
        file=decryptFile(file);
        this.file = file;
        displayFile(file);
        // System.out.println("File received in service: " + file.getOriginalFilename());
    }
    public MultipartFile getFile(){
        return file;
    }
    protected void setFile(MultipartFile file){
        this.file = file;
    }

}
