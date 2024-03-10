import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Main from "./main/index";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CadProd from "./cad.prod/index";
import CadCli from "./cad.cli/index";
import CadFor from "./cad.for/index";
import CadLoj from "./cad.loj/index";
import CadVend from "./cad.vend/index";
import CadEnd from "./cad.end/index";
import MostrarRel from "./mostrar.rel/index";
import RecLot from "./rec.lot/index";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Main />,
  },

  {
    path: "/cad.prod",
    element: <CadProd />,
  },

  {
    path: "/cad.cli",
    element: <CadCli />,
  },

  {
    path: "/cad.for",
    element: <CadFor />,
  },

  {
    path: "/cad.loj",
    element: <CadLoj />,
  },

  {
    path: "/cad.vend",
    element: <CadVend />,
  },

  {
    path: "/cad.end",
    element: <CadEnd />,
  },

  {
    path: "/mostrar.rel",
    element: <MostrarRel />,
  },

  {
    path: "/rec.lot",
    element: <RecLot />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
