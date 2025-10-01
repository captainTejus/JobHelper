import axios from "axios";
import React, { useState } from "react";
import CryptoJS from 'crypto-js';

function ResumeUpload() {
    const ENCRYPTION_KEY = 'your-secret-key-123';
    const [selectedFile, setSelectedFile] = useState(null);
    const [message, setMessage] = useState('');
    
    const encryptFile = async(file) => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = async (e) => {
                try {
                    let encrypted;
                    if (false) {
                        const binaryStr = e.target.result;
                        const wordArray = CryptoJS.lib.WordArray.create(binaryStr);
                        encrypted = CryptoJS.AES.encrypt(wordArray, ENCRYPTION_KEY).toString();
                    } else {
                        encrypted = e.target.result;  // unencrypted version
                    }
                    
                    // Create a new Blob with the encrypted data
                    const encryptedBlob = new Blob([encrypted], { type: 'text/plain' });
                    const encryptedFile = new File([encryptedBlob], file.name + '.encrypted', {
                        type: 'application/octet-stream'
                    });
                    resolve(encryptedFile);
                } catch (error) {
                    console.error('Encryption failed:', error);
                    reject(error);
                }
            };
            reader.onerror = (error) => reject(error);
            reader.readAsArrayBuffer(file);
        });
    };

    const handleFileChange = (event) => {
        setSelectedFile(event.target.files[0]);
        setMessage(''); // Clear any previous messages
    };

    const handleUpload = async () => {
        if (!selectedFile) {
            setMessage('Please select a file first!');
            return;
        }

        try {
            setMessage('Encrypting and uploading file...');
            const encryptedFile = await encryptFile(selectedFile);

            const formData = new FormData();
            formData.append('file', encryptedFile);
            // formData.append('originalFileName', selectedFile.name);

            const response = await axios.post("http://localhost:8081/api/files/upload", formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            setMessage(`File uploaded successfully! Server response: ${response.data}`);
        } catch (error) {
            console.error('Upload failed:', error);
            setMessage('File upload failed: ' + (error.response?.data || error.message));
        }
    };

    return (
        <div>
            <h2>File Upload</h2>
            <input type="file" onChange={handleFileChange} />
            <button onClick={handleUpload}>Upload</button>
            {message && <p>{message}</p>}
        </div>
    );
}

export default ResumeUpload;