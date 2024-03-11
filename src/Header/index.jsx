import * as React from 'react';
import { styled, alpha } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import InputBase from '@mui/material/InputBase';
import style from './style.module.css';
import HomeIcon from '@mui/icons-material/Home';
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';

const SearchIconWrapper = styled('div')(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: '100%',
  position: 'absolute',
  pointerEvents: 'none',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: 'inherit',
  width: '100%',
  '& .MuiInputBase-input': {
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create('width'),
    [theme.breakpoints.up('sm')]: {
      width: '12ch',
      '&:focus': {
        width: '20ch',
      },
    },
  },
}));

export default function Header() {

  const [alignment, setAlignment] = React.useState('web');

  const handleChange = (event, newAlignment) => {
    setAlignment(newAlignment);
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" >
        <Toolbar sx={{backgroundColor: '#00558c'}}>
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
            <ToggleButton value="cad.prod" href='/cad.prod'>Cadastro de Produtos</ToggleButton>
            <ToggleButton value="cad.vend" href="/cad.vend">Cadastro de Vendedor</ToggleButton>
            <ToggleButton value="cad.cli" href="/cad.cli">Cadastro de Cliente</ToggleButton>
            <ToggleButton value="cad.end" href='/cad.end'>Cadastro de Endereço</ToggleButton>
            <ToggleButton value="cad.for" href="/cad.for">Cadastro de Fornecedor</ToggleButton>
            <ToggleButton value="cad.uni" href="/cad.loj">Cadastro de Loja</ToggleButton>
            <ToggleButton value="rec.lot" href="/rec.lot">Recebimento de Lote</ToggleButton>
            <ToggleButton value="mostrar.rel" href="/mostrar.rel">Mostrar Relatório</ToggleButton>
          </ToggleButtonGroup>
          </div>
          
        </Toolbar>
      </AppBar>
    </Box>
  );
}
