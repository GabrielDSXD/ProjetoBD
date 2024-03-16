import Header from "../Header/index";
import style from './style.module.css';
import React, { useState } from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import SendIcon from '@mui/icons-material/Send';

import api from '../api/api'

function DeleteProduto() {

    const [codigo, setCodigo] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();



        api.delete('/produtos/' + codigo + '/deletar')
            .then(response => {
                console.log('Produto ' + codigo + ' deletado com sucesso!', response.data);
                // Limpar os campos do formulário após o envio bem-sucedido
                setCodigo('');
            })
            .catch(error => {
                console.error('Erro ao deletar o produto ' + codigo + ' :', error);
            });
    };


    return (
        <div className={style.fundo}>
            <Header />
            <div className={style.divcard}>
                <div className={style.card}>
                    <div>
                        <h1>Deletar Produto</h1>
                    </div>
                    <div>
                        <form id='cadastro_produto' className={style.form} onSubmit={handleSubmit}>
                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="id"
                                    label="Id"
                                    size='medium'
                                    margin='dense'
                                    variant="filled"
                                    value={codigo}
                                    onChange={(e) => setCodigo(e.target.value)}
                                />
                            </div>
                            <div className={style.botaoEnviar}>
                                <Button type="submit" variant="contained" endIcon={<SendIcon />}>Deletar</Button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DeleteProduto;