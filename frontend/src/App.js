import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Dashboard from './components/Dashboard';
import Categories from './components/Categories.js';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
    return (
        <Router>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <div className="container-fluid">
                    <Link className="navbar-brand" to="/">Inventory System</Link>
                    <div className="collapse navbar-collapse">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <Link className="nav-link" to="/">Dashboard</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/categories">Categories</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div className="container mt-4">
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/categories" element={<Categories />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;