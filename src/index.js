import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Main from "./main/index";
import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";
import CadProd from "./produto/index";
import UpdateProduto from "./produto/update";
import DeleteProduto from "./produto/delete";
import ReadProduto from "./produto/read";
import CadCli from "./cliente/index";
import CadFor from "./fornecedor/index";
import CadLoj from "./loja/index";
import CadVend from "./venda/index";
import CadEnd from "./endereco/index";
import MostrarRel from "./relatorio/index";
import RecLot from "./lote/index";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Main />,
  },

  {
    path: "/produto",
    element: <CadProd />,
  },

  {
    path: "/produto/atualizar",
    element: <UpdateProduto />,
  },

  {
    path: "/produto/deletar",
    element: <DeleteProduto />,
  },

  {
    path: "/produto/listar",
    element: <ReadProduto />,
  },

  {
    path: "/cliente",
    element: <CadCli />,
  },

  {
    path: "/fornecedor",
    element: <CadFor />,
  },

  {
    path: "/loja",
    element: <CadLoj />,
  },

  {
    path: "/venda",
    element: <CadVend />,
  },

  {
    path: "/endereco",
    element: <CadEnd />,
  },

  {
    path: "/relatorio",
    element: <MostrarRel />,
  },

  {
    path: "/lote",
    element: <RecLot />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
