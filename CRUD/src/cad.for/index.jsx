import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';

function Index() {
    return (
        <div>
            <Header />
            <div>
                <h1>Cadastro de Fornecedor</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="razaoSocial" label="Razão Social" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cnpj" label="CNPJ" size='medium'/>
                </div>

                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
}

export default Index;