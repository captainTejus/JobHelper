import axios from "axios";
import React, { useState } from "react";
// console.log("cha;a");
function ResumeUpload() {
		const [selectedFile, setSelectedFile] = useState(null);
  		const [message, setMessage] = useState('');
		
		
		const encryptFile = (text) => {
			// console.log("encrypt chala");
		return text;
		};
  		// Handler for file selection
  		const handleFileChange = (event) => {
			// console.log("cha;a");
    		setSelectedFile(encryptFile(event.target.files[0]));
  		};

  		// Handler for file upload
  		const handleUpload = async () => {
  		if (!selectedFile) {
      		setMessage('Please select a file first!');
      		return;
    	}

    		// Create a FormData object
    	const formData = new FormData();
    	// @RequestParam name in your Spring Boot controller.
    	formData.append('file', selectedFile);

   		try {
    	// Send the POST request to the Spring Boot backend
    	const response = await axios.post("http://localhost:8081/api/files/upload", formData, {
        		headers: {
          		'Content-Type': 'multipart/form-data',
        	},
    		});
    		setMessage("Respone === "+(response.data)); // Display success message from server
    	} catch (error) {
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