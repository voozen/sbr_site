import React from 'react';
import '../styles/pages/Register.css';
import '../components/RegisterForm';
import RegisterForm from '../components/RegisterForm';

function Register() {
    return (
        <>
            <div className='container'>
                <RegisterForm />
            </div>
        </>
    );
}

export default Register;