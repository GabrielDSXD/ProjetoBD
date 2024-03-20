import Header from "../Header/index";
import style from './style.module.css';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import SendIcon from '@mui/icons-material/Send';
import React, { useState, useEffect } from 'react';
import api from '../api/api';

function ReadProdutoByNome() {
    const [produtos, setProdutos] = useState([]);
    const [nome, setNome] = useState('');

    const listarProdutos = () => {
        api.get('/produtos/listar/' + nome)
            .then(response => {
                console.log('Produtos listados por nome com sucesso!', response.data);
                setProdutos(response.data); // Atualiza o estado com os produtos recebidos da API
                setNome('');
            })
            .catch(error => {
                console.error('Erro ao listar produtos por nome:', error);
            });
            const ul = document.querySelector('ul')
            ul.className = ''
    };

    return (
        <div className={style.lista_fundo}>
            <Header />
            <div className={style.divcard}>
                <div className={style.card}>
                    <div>
                        <h1>Lista de Produtos</h1>
                    </div>
                    <div className={style.form}>
                        <ul id='ul' className={style.inactive}>
                            {produtos.map(produto => (
                                <li key={produto.codigo} className="product-item">
                                    Id: {produto.codigo} - {produto.nome} : {produto.descricao} R$ {produto.preco}
                                </li>
                            ))}
                        </ul>
                        <form id='listar_produto' className={style.form}>
                            <div>
                                <TextField
                                    className={style.caixaTextoEspecial}
                                    id="nome"
                                    label="Nome"
                                    size='medium'
                                    margin='dense'
                                    variant="filled"
                                    value={nome}
                                    onChange={(e) => setNome(e.target.value)}
                                />
                            </div>
                            <div className={style.botaoEnviar}>
                                <Button type="button" variant="contained" endIcon={<SendIcon />} onClick={listarProdutos}>Buscar todos</Button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ReadProdutoByNome;
