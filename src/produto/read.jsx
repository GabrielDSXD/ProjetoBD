import Header from "../Header/index";
import style from './style.module.css';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import SendIcon from '@mui/icons-material/Send';
import React, { useState, useEffect } from 'react';
import api from '../api/api';

function ReadProduto() {
    const [produtos, setProdutos] = useState([]);
    const [codigo, setCodigo] = useState('');

    const listarProdutos = () => {
        api.get('/produtos/listar')
            .then(response => {
                console.log('Produtos listados com sucesso!', response.data);
                setProdutos(response.data); // Atualiza o estado com os produtos recebidos da API
                setCodigo('');
            })
            .catch(error => {
                console.error('Erro ao listar produtos:', error);
            });
    };

    const listarProduto = () => {
        api.get(`/produtos/${codigo}`)
            .then(response => {
                console.log('Produto listado com sucesso!', response.data);
                setProdutos([response.data]); // Atualiza o estado com o produto recebido da API
                setCodigo('');
            })
            .catch(error => {
                console.error('Erro ao listar o produto:', error);
            });
    };

    return (
        <div className={style.fundo}>
            <Header />
            <div className={style.divcard}>
                <div className={style.card}>
                    <div>
                        <h1>Lista de Produtos</h1>
                    </div>
                    <div className={style.form}>
                        <ul>
                            {produtos.map(produto => (
                                <li key={produto.codigo} className="product-item">
                                    Id: {produto.codigo} - {produto.nome} : {produto.descricao} ({produto.preco}) - {produto.quantidade}
                                </li>
                            ))}
                        </ul>
                        <form id='listar_produto' className={style.form}>
                        <div>
                            <TextField
                                className={style.caixaTextoEspecial}
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
                            <Button type="button" variant="contained" endIcon={<SendIcon />} onClick={listarProdutos}>Buscar todos</Button>
                        </div>
                        <div className={style.botaoEnviar}>
                            <Button type="button" variant="contained" endIcon={<SendIcon />} onClick={listarProduto}>Buscar um produto</Button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ReadProduto;
