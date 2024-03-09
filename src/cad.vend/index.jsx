import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";

function Index() {
    return (
        <div className={style.body}>
            <Header />
            <div>
                <h1>Cadastro de Vendedor</h1>
            </div>
        </div>
    );
}

export default Index;