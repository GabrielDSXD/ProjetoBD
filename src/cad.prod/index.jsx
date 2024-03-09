import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';

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
                        <TextField className={style.caixaTexto} id="nome" label="Nome" size='medium'/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="descricao" label="Descrição" size='medium'/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="preco" label="Preço" size='medium'/>
                    </div>

                    <div>
                        <TextField className={style.caixaTexto} id="quantidade" label="Quantidade" size='medium'/>
                    </div>

                    <div>
                        <button type="submit">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Index;