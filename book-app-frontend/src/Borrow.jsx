import React, {useEffect, useState} from 'react';
import './BookPage.css'
import harry from './Assets/hp.jpg';
import tkm from './Assets/tkm.jpg';
import sp from './Assets/sp.jpg';
import db from './Assets/db.jpg';
import { useNavigate } from 'react-router-dom';
import { returnBook } from './Api';

const Borrow = () => {
    const navigate = useNavigate();

    const user = JSON.parse(localStorage.getItem("user"));

    const handleReturn = async (e, book) => {
        e.preventDefault();
        // console.log(book);
        const newUser = await returnBook(user.id, book.id);
        localStorage.setItem("user", JSON.stringify(newUser));
        alert("Poti sa restitui cartea la biblioteca!");
        window.location.reload();
    }

    return(
        <div className='book-list-container'>
            {user.books.length == 0 && <h1>Nu ai carti imprumutate...</h1>}
            {user.books.length > 0 && (<h1>Lista de Carti Imprumutate</h1>) && user.books.map(book => (
                    <li key={book.id} className='book-item'>
                        <img src={book.image} alt={book.title} className='book-image' />
                        <div className='book-info'>
                            <h3>{book.title}</h3>
                            <p><strong>Author: </strong>{book.author}</p>
                            <p><strong>Gen: </strong>{book.type}</p>
                            <button onClick={(e) => handleReturn(e, book)}>Restituie</button>
                        </div>
                    </li>
                ))}
                <button onClick={() => navigate("/book")}>Mergi inapoi</button>
            <ul className='book-list'>
            </ul>
        </div>
    )
}

export default Borrow;