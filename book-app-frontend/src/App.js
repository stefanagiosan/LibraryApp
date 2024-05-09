import React, {useEffect, useState} from 'react';
import {Route, BrowserRouter, Routes, Navigate}   from 'react-router-dom';
import  LoginForm  from './Auth/LoginForm';
import RegistrationForm from './Auth/RegistrationForm';
import BooksPage from './BooksPage';
import Borrow from './Borrow';

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = (username, password) => {
    setIsLoggedIn(true);
  }


  return (
    <>
    <BrowserRouter>
        <Routes>
          <Route path="/login" element={<LoginForm />} />
          <Route path="/register" element={<RegistrationForm />} />
          <Route path="/book" element={<BooksPage/>} />
          <Route path="/borrow" element={<Borrow/>} />
          <Route path="*" element={<Navigate to="/login"/>} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
