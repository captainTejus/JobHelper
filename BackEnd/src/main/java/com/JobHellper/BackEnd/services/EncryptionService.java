package com.JobHellper.BackEnd.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class EncryptionService {
    private static final String ENCRYPTION_KEY = "your-secret-key-123";
    private static final String ALGORITHM = "AES";

    // Create a static inner class to implement MultipartFile
    private static class DecryptedMultipartFile implements MultipartFile {
        private final byte[] content;
        private final String filename;
        private final String originalFilename;

        public DecryptedMultipartFile(byte[] content, String filename, String originalFilename) {
            this.content = content;
            this.filename = filename;
            this.originalFilename = originalFilename;
        }

        @Override
        public String getName() {
            return filename;
        }

        @Override
        public String getOriginalFilename() {
            return originalFilename;
        }

        @Override
        public String getContentType() {
            return "application/octet-stream";
        }

        @Override
        public boolean isEmpty() {
            return content.length == 0;
        }

        @Override
        public long getSize() {
            return content.length;
        }

        @Override
        public byte[] getBytes() throws IOException {
            return content;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(content);
        }

        @Override
        public void transferTo(File dest) throws IOException {
            try (FileOutputStream fos = new FileOutputStream(dest)) {
                fos.write(content);
            }
        }
    }

    public byte[] decrypt(byte[] encryptedData) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        return cipher.doFinal(decodedData);
    }

    public MultipartFile decryptFile(MultipartFile encryptedFile) throws Exception {
        String encryptedContent = new String(encryptedFile.getBytes(), StandardCharsets.UTF_8);
        byte[] decryptedBytes = decrypt(encryptedContent.getBytes());
        String originalFilename = encryptedFile.getOriginalFilename();
        if (originalFilename != null) {
            originalFilename = originalFilename.replace(".encrypted", "");
        }
        return new DecryptedMultipartFile(
            decryptedBytes,
            encryptedFile.getName(),
            originalFilename
        );
    }
}