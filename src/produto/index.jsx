import Header from "../Header/index";
import style from './style.module.css';
import React, { useState } from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import SendIcon from '@mui/icons-material/Send';

import api from '../api/api'

function Index() {

    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [preco, setPreco] = useState('');
    const [quantidade, setQuantidade] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        const produto = {
            nome: nome,
            descricao: descricao,
            preco: preco,
            quantidade: quantidade
        };
        
        api.post('/produtos/cadastrar', produto)
            .then(response => {
                console.log('Produto cadastrado com sucesso!', response.data);
                // Limpar os campos do formulário após o envio bem-sucedido
                setNome('');
                setDescricao('');
                setPreco('');
                setQuantidade('');
            })
            .catch(error => {
                console.error('Erro ao cadastrar produto:', error);
            });
    };


    return (
        <div className={style.fundo}>
            <Header />
            <div className={style.divcard}>
                <div className={style.card}>
                    <div>
                        <h1>Cadastro de Produto</h1>
                    </div>
                    <div>
                        <form id='cadastro_produto' className={style.form} onSubmit={handleSubmit}>
                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="nome"
                                    label="Nome"
                                    size='medium'
                                    margin='dense'
                                    variant="filled"
                                    value={nome}
                                    onChange={(e) => setNome(e.target.value)}
                                />
                            </div>
                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="descricao"
                                    label="Descrição"
                                    size='medium'
                                    margin='dense'
                                    variant="filled"
                                    value={descricao}
                                    onChange={(e) => setDescricao(e.target.value)}
                                />
                            </div>
                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="preco"
                                    label="Preço"
                                    size='medium'
                                    margin='dense'
                                    variant="filled"
                                    value={preco}
                                    onChange={(e) => setPreco(e.target.value)}
                                />
                            </div>
                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="quantidade"
                                    label="Quantidade"
                                    size='medium'
                                    margin='dense'
                                    variant="filled"
                                    value={quantidade}
                                    onChange={(e) => setQuantidade(e.target.value)}
                                />
                            </div>
                            <div className={style.botaoEnviar}>
                                <Button type="submit" variant="contained" endIcon={<SendIcon />}>Enviar</Button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Index;