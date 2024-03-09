import React, { useEffect } from "react";
import Header from "../Header/index";
import style from "./style.module.css";
import logo from "../assets/logoBD.png";

export default function mainpage() {
  return (
    <div className={style.fundo}>
      <Header />
      <div>
        <h1>Projeto BD</h1>
      </div>
      <div>
        <img className={style.logo} src={logo} alt="Logo" />
      </div>
    </div>
  );
}