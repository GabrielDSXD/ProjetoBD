import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import SendIcon from '@mui/icons-material/Send';

function Index() {
    return (
        <div className={style.fundo}>
            <Header />
            <div className={style.divcard}>
            <div className={style.card}>
            <div>
                <h1>Cadastro de Fornecedor</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="razaoSocial" label="Razão Social" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cnpj" label="CNPJ" size='medium' margin='dense' variant="filled"/>
                </div>

                <div className={style.botaoEnviar}>
                    <Button variant="contained" endIcon={<SendIcon />}>Enviar</Button>
                </div>
            </form>
            </div>
            </div>
        </div>
    );
}

export default Index;