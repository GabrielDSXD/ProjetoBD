import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';

function Index() {
    return (
        <div className={style.body}>
            <Header />
            <div>
                <h1>Cadastro de Vendedor</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cpf" label="CPF" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="codLoj" label="Código da Loja" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="Telefone" label="Telefone" size='medium'/>
                </div>

                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
}

export default Index;