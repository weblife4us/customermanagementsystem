import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {BrowserRouter} from "react-router-dom";
import AppRouter from "./component/navigation/AppRouter";

const router = (
    <BrowserRouter>
        <AppRouter/>
    </BrowserRouter>
);

ReactDOM.render(router, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
// serviceWorker.unregister();
