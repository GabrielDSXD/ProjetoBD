import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';

function Index() {
    return (
        <div>
            <Header />
            <div>
                <h1>Cadastro de Endereço</h1>
            </div>

            <form>
                <div>
                    <TextField className={style.caixaTexto} id="cidade" label="Cidade" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="estado" label="Estado" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="numero" label="Número" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="cep" label="CEP" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="complemento" label="Complemento" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="bairro" label="Bairro" size='medium'/>
                </div>

                <div>
                    <TextField className={style.caixaTexto} id="logradouro" label="Logradouro" size='medium'/>
                </div>

                <button type="submit">Cadastrar</button>
            </form>

        </div>
    );
}

export default Index;