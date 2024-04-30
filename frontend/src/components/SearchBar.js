import React from 'react';
import { useState } from 'react';

function SearchBarLabel() {
    return (
        <>
            <div>
                Znajdź lekarza i umów<br></br>
                wizytę<br></br>
                Wybierz spośród tysięcy<br></br>
                specjalistów z całej Polski
            </div>
        </>
    );
}

function MainInputField({ filterText, onFilterTextChange }) {
    return (
        <input 
            type='text' 
            value={filterText} 
            placeholder='Speciality, test type...' 
            onChange={(e) => onFilterTextChange(e.target.value)}
        />
    );
}

function CityInputField({ filterText, onFilterTextChange }) {
    return (
        <input 
            type='text' 
            value={filterText} 
            placeholder='City...' 
            onChange={(e) => onFilterTextChange(e.target.value)}
        />
    );
}

function SearchButton() {
    function handleClick() {

    }

    return (
        <button style={{height: '2em', width: '6em'}} onClick={() => handleClick()} >Search</button>
    );
}

function PrototypeResultList() {
    return (
        <>
        </>
    );
}

function SearchBar() {
    const [mainFilterText, setMainFilterText] = useState('');
    const [cityFilterText, setCityFilterText] = useState('');

    return (
        <>
            <div className='searchbar-container'>
                <SearchBarLabel />
                <div className='input-fields'>
                    <MainInputField 
                        filterText={mainFilterText}
                        onFilterTextChange={setMainFilterText}
                    />
                    <CityInputField
                        filterText={cityFilterText}
                        onFilterTextChange={setCityFilterText}
                    />
                </div>
                <SearchButton />
            </div>
            <PrototypeResultList />
        </>
    );
}

export default SearchBar;