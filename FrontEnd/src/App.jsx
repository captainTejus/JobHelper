import { useState, useEffect } from 'react';
// import reactLogo from './assets/react.svg';
import './App.css';
import ResumeUpload from './component/ResumeUpload';


function App() {
//   const [count, setCount] = useState(0);
//   const [message, setMessage] = useState('');
//   const [apiResponse, setApiResponse] = useState(null);

//   useEffect(() => {
//     fetch(`/api/v1/test/${count}`)
//       .then(response => {
//         if (!response.ok) {
//           throw new Error('Network response was not ok');
//         }
//         return response.json();
//       })
//       .then(data => {
//         setMessage(data.message);
//         setApiResponse(data);
//       })
//       .catch(error => {
//         setMessage('Error fetching data');
//         setApiResponse(null);
//         console.error('Error fetching data:', error);
//       });
//   }, [count]);
// // Removed duplicate and broken useEffect code block
//   return (
//     <div className="App">
//       {/* <div>
//         <a href="https://vitejs.dev" target="_blank">
//           <img src="/vite.svg" className="logo" alt="Vite logo" />
//         </a>
//         <a href="https://reactjs.org" target="_blank">
//           <img src={reactLogo} className="logo react" alt="React logo" />
//         </a>
//       </div> */}
//       <h1>Vite + React</h1> 
//       <div className="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/App.jsx</code> and save to test HMR
//         </p>
//         <div>
//           <strong>API Message:</strong> {message}
//         </div>
//         <div>
//           <strong>Full API Response:</strong> <pre>{apiResponse ? JSON.stringify(apiResponse, null, 2) : 'No data'}</pre>
//         </div> 
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//     </div>
//   );
return(
  // ResumeUpload()
  // +
<div>
  <ResumeUpload/>
  <br/>
  <div>
    APP
  </div>
</div>


  );
}

export default App;
