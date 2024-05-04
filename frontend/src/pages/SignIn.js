import React from 'react';
import '../styles/pages/SignIn.css';
import '../components/SignInForm';

function SignIn() {
    return (
        <>
            <div className='container'>
                Sign in!
                <SignInForm />
            </div>
        </>
    );
}

export default SignIn;