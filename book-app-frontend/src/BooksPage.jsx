import React, {useEffect, useState} from 'react';
import './BookPage.css'
import harry from './Assets/hp.jpg';
import tkm from './Assets/tkm.jpg';
import sp from './Assets/sp.jpg';
import db from './Assets/db.jpg';
import { borrowBook, getAllBooks } from './Api';
import { useNavigate } from 'react-router-dom';

const BooksPage = () => {
    const [books, setBooks] = useState([]);
    const navigate = useNavigate();

    const user = JSON.parse(localStorage.getItem("user"));

    useEffect(() => {
        const getData = async () => {
            const res = await getAllBooks();
            setBooks(res);
        }

        getData();
    }, []);

    const handleLogout = (e) => {
        e.preventDefault();
        localStorage.removeItem("user");
        navigate("/login");
    }

    const handleBorrowBook = async (e, borrowedBook) => {
        e.preventDefault();

        let found = false;
        for(let book of user.books) {
            if(book.id === borrowedBook.id) {
                found = true;
            }
        }

        if(found === true) {
            alert("Ai imprumutat deja aceasta carte!!");
        }
        else {
            const newUser = await borrowBook(user.id, borrowedBook.id);
            console.log(newUser);
            localStorage.setItem("user", JSON.stringify(newUser));
            alert("Cartea a fost imprumutata!!");
            window.location.reload();
        }
    }

    return(
        <div className='book-list-container'>
            <h1>Lista de Carti</h1>
            {books && books.map(book => (
                    <li key={book.id} className='book-item'>
                        <img src={harry} alt={book.title} className='book-image' />
                        <div className='book-info'>
                            <h3>{book.title}</h3>
                            <p><strong>Author: </strong>{book.author}</p>
                            <p><strong>Gen: </strong>{book.type}</p>
                            <p><strong>Numar disponibile: </strong>{book.numberOfBooks}</p>
                            <button onClick={(e) => handleBorrowBook(e, book)}>Imprumuta</button>
                        </div>
                    </li>
                ))}
                <button onClick={() => navigate("/borrow")}>Vezi cartile imprumutate</button>
                <button onClick={(e) => handleLogout(e)}>Logout</button>
            <ul className='book-list'>
            </ul>
        </div>
    )
}

export default BooksPage;