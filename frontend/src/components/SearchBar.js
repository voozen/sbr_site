import React, { useState } from 'react';
import axios from 'axios';

function SearchBarLabel() {
    return (
        <div>
            <span style={{ fontSize: '1.5em', fontWeight: '600' }}>
                Znajdź lekarza i umów<br />
                wizytę<br />
            </span>
            <span style={{ fontSize: '1.4em', color: '#C0C0C0', fontWeight: '600' }}>
                Wybierz spośród tysięcy<br />
                specjalistów z całej Polski
            </span>
        </div>
    );
}

function MainInputField({ filterText, onFilterTextChange }) {
    return (
        <div style={{ paddingTop: '0.5em', paddingBottom: '0.5em' }}>
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
        <div style={{ paddingBottom: '0.5em' }}>
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

function SearchButton({ setDoctors, mainFilterText, cityFilterText }) {
    function handleClick() {
        const params = {};
        params.mainFilter = mainFilterText;
        params.cityFilter = cityFilterText;
        if (mainFilterText && cityFilterText) {
            axios
                .get(
                    'http://130.61.53.214:8080/searchDoctor?cat=' +
                        params.mainFilter +
                        '&cit=' +
                        params.cityFilter
                )
                .then((response) => {
                    setDoctors(response.data);
                })
                .catch((error) => {
                    console.error('There was a problem with your axios operation:', error);
                });
        } else if (mainFilterText) {
            axios
                .get('https://130.61.53.214:8080/searchDoctor?cat=' + params.mainFilter)
                .then((response) => {
                    setDoctors(response.data);
                })
                .catch((error) => {
                    console.error('There was a problem with your axios operation:', error);
                });
        } else if (cityFilterText) {
            axios
                .get('https://130.61.53.214:8080/searchDoctor?cit=' + params.cityFilter)
                .then((response) => {
                    setDoctors(response.data);
                })
                .catch((error) => {
                    console.error('There was a problem with your axios operation:', error);
                });
        }
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
                onClick={handleClick}
            >
                Szukaj
            </button>
        </div>
    );
}

function DoctorTable({ doctors }) {
    return (
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Adres ID</th>
                    <th>Numer telefonu</th>
                    <th>Miasto</th>
                    <th>Kategoria</th>
                </tr>
            </thead>
            <tbody>
                {doctors.map((doctor) => (
                    <tr key={doctor.doctorID}>
                        <td>{doctor.doctorID}</td>
                        <td>{doctor.firstName}</td>
                        <td>{doctor.lastName}</td>
                        <td>{doctor.addressID}</td>
                        <td>{doctor.phoneNumber}</td>
                        <td>{doctor.city}</td>
                        <td>{doctor.category}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

function SearchBar() {
    const [mainFilterText, setMainFilterText] = useState('');
    const [cityFilterText, setCityFilterText] = useState('');
    const [doctors, setDoctors] = useState([]);

    return (
        <div style={{ display: 'grid', justifyContent: 'center' }}>
            <SearchBarLabel />
            <div>
                <MainInputField filterText={mainFilterText} onFilterTextChange={setMainFilterText} />
                <CityInputField filterText={cityFilterText} onFilterTextChange={setCityFilterText} />
            </div>
            <SearchButton
                setDoctors={setDoctors}
                mainFilterText={mainFilterText}
                cityFilterText={cityFilterText}
            />
            <DoctorTable doctors={doctors} />
        </div>
    );
}

export default SearchBar;