import React, { useState } from 'react';
import './LoginForm.css';
import { FaLock, FaUser } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { loginUser } from '../Api';
import RegistrationForm from './RegistrationForm';
import { useNavigate } from 'react-router-dom';


function LoginForm() {
    const[username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        if (username.trim() === '' || password.trim() === '')
        {
            alert('Introduceti username-ul si parola!');
            return;
        }

        const loginData = {name: username, password: password};
        const user = await loginUser(loginData);
        localStorage.setItem('user', JSON.stringify(user));
        navigate("/book");
        
    };

    return (
        <div className='wrapper'>
            <form action=''>
                <h1>Login</h1>
                <div className='input-box'>
                    <input type='text' placeholder='Username' required onChange={(e) => setUsername(e.target.value)} />
                    <FaUser className='icon' />
                </div>
                <div className='input-box'>
                    <input type="password" placeholder='Password' required onChange={(e) => setPassword(e.target.value)} />
                    <FaLock className='icon' />
                </div>
    
                <button type='submit' onClick={(e) => handleLogin(e)}>Login</button>
    
                <div className='register-link'>
                    <p>Don't have an account? <Link to= "/register" element={<RegistrationForm />}>Register</Link></p>
                </div>
    
            </form>
    
        </div>
      );
}


export default LoginForm;
