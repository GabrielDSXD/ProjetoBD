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
                <h1>Cadastro de Endereço</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="cidade" label="Cidade" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="estado" label="Estado" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="numero" label="Número" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cep" label="CEP" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="complemento" label="Complemento" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="bairro" label="Bairro" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="logradouro" label="Logradouro" size='medium' margin='dense' variant="filled"/>
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