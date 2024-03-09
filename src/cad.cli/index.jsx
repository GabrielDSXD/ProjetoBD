import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import { TextField } from '@mui/material';

function Index() {
    return (
        <div>
            <Header />
            <div>
                <h1>Cadastro de Clientes</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cpf/cnpj" label="CPF/CNPJ" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="endereço" label="Endereço" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="telefone" label="Telefone" size='medium'/>
                </div>

                <button type="submit">Cadastrar</button>
            </form>

        </div>
    );
}

export default Index;