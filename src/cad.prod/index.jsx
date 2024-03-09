import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import SendIcon from '@mui/icons-material/Send';

function Index() {
    return (    

        <div>
            <Header />
            <div>
                <h1>Cadastro de Produto</h1>
            </div>

            <div>
                <form className={style.form}>
                    <div>
                        <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium' margin='dense' variant="filled"/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="descricao" label="Descrição" size='medium' margin='dense' variant="filled"/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="preco" label="Preço" size='medium' margin='dense' variant="filled"/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="quantidade" label="Quantidade" size='medium' margin='dense' variant="filled"/>
                    </div>

                    <div className={style.botaoEnviar}>
                        <Button variant="contained" endIcon={<SendIcon />}>Enviar</Button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Index;