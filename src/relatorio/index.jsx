import React from 'react';
import style from './style.module.css';
import Header from "../Header/index";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import SendIcon from '@mui/icons-material/Send';



function Index() {
    const [nome, setNome] = React.useState('');
    const [descricao, setDescricao] = React.useState('');
    const [preco, setPreco] = React.useState('');
    const [quantidade, setQuantidade] = React.useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = {
            nome,
            descricao,
            preco,
            quantidade
        };
        console.log(formData);
        // You can do further processing with the form data here
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
                        <form className={style.form} onSubmit={handleSubmit}>
                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="nome"
                                    label="Nome"
                                    size="medium"
                                    margin="dense"
                                    variant="filled"
                                    value={nome}
                                    onChange={(event) => setNome(event.target.value)}
                                />
                            </div>

                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="descricao"
                                    label="Descrição"
                                    size="medium"
                                    margin="dense"
                                    variant="filled"
                                    value={descricao}
                                    onChange={(event) => setDescricao(event.target.value)}
                                />
                            </div>

                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="preco"
                                    label="Preço"
                                    size="medium"
                                    margin="dense"
                                    variant="filled"
                                    value={preco}
                                    onChange={(event) => setPreco(event.target.value)}
                                />
                            </div>

                            <div>
                                <TextField
                                    className={style.caixaTexto}
                                    id="quantidade"
                                    label="Quantidade"
                                    size="medium"
                                    margin="dense"
                                    variant="filled"
                                    value={quantidade}
                                    onChange={(event) => setQuantidade(event.target.value)}
                                />
                            </div>

                            <div className={style.botaoEnviar}>
                                <Button variant="contained" endIcon={<SendIcon />} type="submit">
                                    Enviar
                                </Button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Index;