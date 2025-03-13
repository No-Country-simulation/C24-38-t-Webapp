import React from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Home() {
  const navigate = useNavigate();

  return (
    <div className="flex flex-col items-center justify-start min-h-screen bg-gray-100 overflow-y-auto space-y-4 pb-24">
      <h1 className="text-3xl font-bold mb-6 text-[#4EA7A7]">¡Bienvenido!</h1>

      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-4"
        onClick={() => navigate("/clinical-history")}
      >
        Historial Clinico
      </button>
      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-8"
        onClick={() => navigate("/datos-personales")}
      >
        Datos personales
      </button>

      <Link to="/schedule-appointments" className="max-w-[360px] w-full h-[197px] flex items-center justify-center border-2 border-[#4EA7A7] rounded-[15px] p-4 mb-4 bg-white mx-4">
        <img
          src="/src/assets/images/home/turnos.svg"
          alt="Icono"
          className="w-1/3 h-auto object-contain"
        />
        <span className="ml-4 text-lg font-semibold">Turnos</span>
      </Link>

      <div className="max-w-[360px] w-full h-[197px] flex items-center justify-center border-2 border-[#4EA7A7] rounded-[15px] p-4 bg-white  mx-4">
        <img
          src="/src/assets/images/home/pendientes.svg"
          alt="Icono"
          className="w-1/3 h-auto object-contain"
        />
        <span className="ml-4 text-lg font-semibold">Citas Pendientes</span>
      </div>
    </div>
  );
}