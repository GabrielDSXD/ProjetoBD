import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import { TextField } from '@mui/material';
import Button from '@mui/material/Button';
import SendIcon from '@mui/icons-material/Send';

function Index() {
    return (
        <div>
            <Header />
            <div>
                <h1>Cadastro de Clientes</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cpf/cnpj" label="CPF/CNPJ" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="endereço" label="Endereço" size='medium' margin='dense' variant="filled"/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="telefone" label="Telefone" size='medium' margin='dense' variant="filled"/>
                </div>

                <div className={style.botaoEnviar}>
                    <Button variant="contained" endIcon={<SendIcon />}>Enviar</Button>
                </div>
            </form>

        </div>
    );
}

export default Index;