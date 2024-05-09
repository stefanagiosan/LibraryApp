import axios from 'axios';


export const loginUser = async (loginData) => {
    try{
        const rez = await axios.post("http://localhost:8080/users/login" , loginData);
        return Promise.resolve(rez.data);
    }
    catch (err){
        return Promise.reject(err);
    }
}

export const getAllBooks = async () => {
    try {
        const res = await axios.get("http://localhost:8080/books");
        return Promise.resolve(res.data);
    }
    catch(err) {
        return Promise.reject(err);
    }
}

export const registerUser = async(registerData) => {
    try {
        const res = await axios.post("http://localhost:8080/users/register", registerData);
        return Promise.resolve(res.data);
    }
    catch(err) {
        return Promise.reject(err);
    }
}

export const borrowBook = async (userId, bookId) => {
    try {
        const res = await axios.put(`http://localhost:8080/users/${userId}/borrow/${bookId}`);
        return Promise.resolve(res.data);
    }
    catch(err) {
        return Promise.reject(err);
    }
}

export const returnBook = async (userId, bookId) => {
    try {
        const res = await axios.put(`http://localhost:8080/users/${userId}/return/${bookId}`);
        return Promise.resolve(res.data);
    }
    catch(err) {
        return Promise.reject(err);
    }
}