import "../styles/Navbar.css";
import React from 'react';
import { useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import { Route, Routes, Link } from 'react-router-dom';

function Navbar() {
  const navRef = useRef();

  const showNavbar = () => {
    navRef.current.classList.toggle(
      "responsive_nav"
    );
  };

  return (
    <>
      <header>
        <h3>LOGO</h3>
        <nav ref={navRef}>
          <ul className='navbar-option'>
            <Link className='navbar-link' to="/">
              home
            </Link>
          </ul>
          <ul className='navbar-option'>
            <Link className='navbar-link' to="/dashboard">
              dashboard
            </Link>
          </ul>
          <ul className='navbar-option'>
            <Link className='navbar-link' to="/about">
              about
            </Link>
          </ul>
          <button
            className="nav-btn nav-close-btn"
            onClick={showNavbar}>
            <FaTimes />
          </button>
        </nav>
        <button
          className="nav-btn"
          onClick={showNavbar}>
          <FaBars />
        </button>
      </header>
    </>
  );
}

export default Navbar;
