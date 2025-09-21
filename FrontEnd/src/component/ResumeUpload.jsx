import axios from "axios";
import React, { useState } from "react";

function ResumeUpload() {
    // const [selectedFile, setSelectedFile] = useState(null);
	// const onFileChange = (event) => {
	// 	setSelectedFile(event.target.files[0]);
	// };
	// const onFileUpload = () => {
    //     //// upload file encryption api handilng etc.
	// 	const formData = new FormData();
	// 	formData.append(
	// 		"myFile",
	// 		selectedFile,
	// 		selectedFile.name
	// 	);
	// 	console.log(selectedFile);
	// 	axios.post("api/uploadfile", formData);
	// };
	// const fileData = () => {
	// 	if (selectedFile) {
	// 		return (
	// 			<div>
	// 				<h2>File Details:</h2>
	// 				<p>File Name: {selectedFile.name}</p>
	// 				<p>File Type: {selectedFile.type}</p>
	// 				<p>
	// 					Last Modified: {selectedFile.lastModifiedDate.toDateString()}
	// 				</p>
	// 			</div>
	// 		);
	// 	} else {
	// 		return (
	// 			<div>
	// 				<br />
	// 				<h4>Choose before Pressing the Upload button</h4>
	// 			</div>
	// 		);
	// 	}
		const [selectedFile, setSelectedFile] = useState(null);
  		const [message, setMessage] = useState('');

  		// Handler for file selection
  		const handleFileChange = (event) => {
    		setSelectedFile(event.target.files[0]);
  		};

  		// Handler for file upload
  		const handleUpload = async () => {
  		if (!selectedFile) {
      		setMessage('Please select a file first!');
      		return;
    	}

    		// Create a FormData object
    	const formData = new FormData();
    	// Append the file with the key 'file'. This key MUST match the
    	// @RequestParam name in your Spring Boot controller.
    	formData.append('file', selectedFile);

   		try {
    	// Send the POST request to the Spring Boot backend
    	const response = await axios.post("http://localhost:5173/api/files/upload", formData, {
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
    // return (
    // <div className="ResumeUpload">
    //     <div>
	// 		<h1>ResumeUpload</h1>
	// 		<h3>File Upload using React!</h3>
	// 		<div>
	// 			<input type="file" onChange={onFileChange} />
	// 			<button onClick={onFileUpload}>Upload!</button>
	// 		</div>
	// 		{fileData()}
	// 	</div>
    // </div>

    // );
}
export default ResumeUpload;