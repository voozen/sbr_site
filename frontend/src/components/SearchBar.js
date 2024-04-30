import React from 'react';
import { useState } from 'react';

function SearchBarLabel() {
    return (
        <>
            <div>
                <span style={{fontSize: '1.5em', fontWeight: '600'}}>
                Znajdź lekarza i umów<br></br>
                wizytę<br></br>
                </span>
                <span style={{fontSize: '1.4em', color: '#C0C0C0', fontWeight: '600'}}>
                Wybierz spośród tysięcy<br></br>
                specjalistów z całej Polski
                </span>
            </div>
        </>
    );
}

function MainInputField({ filterText, onFilterTextChange }) {
    return (
        <div style={{paddingTop: '0.5em', paddingBottom: '0.5em'}}>
            <input 
                type='text' 
                value={filterText} 
                placeholder='Specjalizacja, badanie...' 
                onChange={(e) => onFilterTextChange(e.target.value)}
                style={{
                    borderRadius: '0.25em',
                    border: '0.1em solid #666',
                    background: '#FFF',
                    width: '20em',
                    height: '2.5em',
                    paddingLeft: '0.5em'
                }}
            />
        </div>
    );
}

function CityInputField({ filterText, onFilterTextChange }) {
    return (
        <div style={{paddingBottom: '0.5em'}}>
            <input 
                type='text' 
                value={filterText} 
                placeholder='Miasto...' 
                onChange={(e) => onFilterTextChange(e.target.value)}
                style={{
                    borderRadius: '0.25em',
                    border: '0.1em solid #666',
                    background: '#FFF',
                    width: '10em',
                    height: '2.5em',
                    paddingLeft: '0.5em'
                }}
            />
        </div>
    );
}

function SearchButton() {
    function handleClick() {

    }

    return (
        <div>
            <button
                style={{
                    width: '5em',
                    height: '2em',
                    borderRadius: '0.75em',
                    border: '0.1em solid #666',
                    background: '#FFF'
                }}
                onClick={() => handleClick()}>
                Szukaj
            </button>
        </div>
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
            <div style={{display: 'grid', justifyContent: 'center'}}>
                <SearchBarLabel />
                <div>
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