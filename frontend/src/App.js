import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/About';

function App() {
  return (
    <div className='container'>
      <div className='navigation'>
        <nav className='navbar'>
          <ul className='navbar-option'>
            <Link className='navbar-link' to="/">
              home
            </Link>
          </ul>
          <ul className='navbar-option'>
            <Link className='navbar-link' to="/about">
              about
            </Link>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
