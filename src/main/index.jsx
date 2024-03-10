import React, { useEffect } from "react";
import Header from "../Header/index";
import style from "./style.module.css";
import logo from "../assets/logoBD.png";

export default function mainpage() {
  return (
    <div className={style.fundo}>
      <Header />
      <div className={style.divtittle}>
      <div className={style.card}>
        <h1 className={style.tittle}>Projeto BD</h1>
      </div>
      </div>

      <div>
        <img className={style.logo} src={logo} alt="Logo" />
      </div>

      <div className={style.linha}>
        <div className={style.box}>
          <h2 className={style.integrantes}>Integrantes:</h2>
          <p>Arthur Ramon</p>
          <p>Gabriel Dantas</p>
          <p>Davi Baratto</p>
        </div>
      </div>

    </div>
  );
}