import React, { useState } from "react";
import './LoginForm.css';
import { FaLock, FaUser, FaHome, FaPhone } from 'react-icons/fa';
import { AiFillBook } from 'react-icons/ai';
import { useNavigate } from "react-router-dom";
import { registerUser } from "../Api";


export const RegistrationForm = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [cnp, setCnp] = useState("");
    const [address, setAddress] = useState("");
    const [phone, setPhone] = useState("");

    const navigate = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault();

        const registerData = {
            name: username,
            password: password,
            cnp: cnp,
            address: address,
            phone: phone
        };

        const user = await registerUser(registerData);
        alert("Te-ai inregistrat cu succes!!");
        localStorage.setItem("user", JSON.stringify(user));
        navigate("/book");

    }

    return(
        <div className='wrapper'>
            <form action=''>
                <h2>Registration</h2>
                <div className="input-box">
                    <input type='text' placeholder="Username" required onChange={(e) => setUsername(e.target.value)} />
                    <FaUser className='icon' />
                </div>
                <div className="input-box">
                    <input type="password" placeholder="Password" required onChange={(e) => setPassword(e.target.value)} />
                    <FaLock className='icon' />
                </div>
                <div className="input-box">
                    <input type='text' placeholder="Cnp" required onChange={(e) => setCnp(e.target.value)} />
                    <AiFillBook className='icon' />
                </div>
                <div className="input-box">
                    <input type='text' placeholder="Address" required onChange={(e) => setAddress(e.target.value)} />
                    <FaHome className="icon" />
                </div>
                <div className="input-box">
                    <input type="text" placeholder="Phone" required onChange={(e) => setPhone(e.target.value)} />
                    <FaPhone className="icon" />
                </div>

                <button type='submit' onClick={(e) => handleRegister(e)}>Register</button>

            </form>
        </div>
    );
};

export default RegistrationForm;