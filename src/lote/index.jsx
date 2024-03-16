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
                    <h1>Recebimento de Lote</h1>
                </div>

                <form className={style.form}>
                    <div>
                        <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium' margin='dense' variant="filled"/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="endereco" label="Endereço" size='medium' margin='dense' variant="filled"/>
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