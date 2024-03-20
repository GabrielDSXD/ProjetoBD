import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import style from './style.module.css';
import HomeIcon from '@mui/icons-material/Home';
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';

export default function Header() {

  const [alignment, setAlignment] = React.useState('web');

  const handleChange = (event, newAlignment) => {
    setAlignment(newAlignment);
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" >
        <Toolbar sx={{ backgroundColor: '#00558c' }}>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="home icon"
            sx={{ mr: 2 }}
            onClick={() => {
              window.location.href = "/";
            }}
          >
            <HomeIcon />
          </IconButton>

          <div className={style.paginas}>
            <ToggleButtonGroup
              color="primary"
              value={alignment}
              exclusive
              onChange={handleChange}
              aria-label="Platform"
            >
              <ToggleButton value="save_produto" href='/produto'>Cadastro de Produtos</ToggleButton>
              <ToggleButton value="update_produto" href='/produto/atualizar'>Atualizar Produto</ToggleButton>
              <ToggleButton value="delete_produto" href='/produto/deletar'>Deletar Produto</ToggleButton>
              <ToggleButton value="listar_produtos" href='/produto/listar'>Listar Produtos</ToggleButton>
              <ToggleButton value="listar_produtos" href='/produto/listar-nome'>Listar Produtos Por Nome</ToggleButton>z
              {/* <ToggleButton value="cad.vend" href="/venda">Cadastro de Vendedor</ToggleButton>
            <ToggleButton value="cad.cli" href="/cliente">Cadastro de Cliente</ToggleButton>
            <ToggleButton value="cad.end" href='/endereco'>Cadastro de Endereço</ToggleButton>
            <ToggleButton value="cad.for" href="/fornecedor">Cadastro de Fornecedor</ToggleButton>
            <ToggleButton value="cad.uni" href="/loja">Cadastro de Loja</ToggleButton>
            <ToggleButton value="rec.lot" href="/lote">Recebimento de Lote</ToggleButton>
            <ToggleButton value="mostrar.rel" href="/relatorio">Mostrar Relatório</ToggleButton> */}
            </ToggleButtonGroup>
          </div>

        </Toolbar>
      </AppBar>
    </Box>
  );
}
