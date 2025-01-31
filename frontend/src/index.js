import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

// Create a root element for React to render into
const root = ReactDOM.createRoot(document.getElementById('root'));

// Render the App component
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
