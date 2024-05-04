import React from 'react';
import SearchBar from '../components/SearchBar';
import '../styles/pages/Home.css';

function Home() {
    return (
        <>
            <div style={{display: 'grid', width: '100%'}}>
                home
                <SearchBar />
            </div>
        </>
    );
}

export default Home;