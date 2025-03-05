import React, { useState } from "react";

export default function Home() {
  const [button1Clicked, setButton1Clicked] = useState(false);
  const [button2Clicked, setButton2Clicked] = useState(false);

  return (
    <div className="flex flex-col items-center justify-start min-h-screen bg-gray-100 p-4 overflow-y-auto space-y-4">

      <h1 className="text-3xl font-bold mb-6">¡Bienvenido!</h1>

      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-4"
        onClick={() => setButton1Clicked(!button1Clicked)}
      >
        {button1Clicked ? "Historial Clinico" : "Historial Clinico"}
      </button>
      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-8"
        onClick={() => setButton2Clicked(!button2Clicked)}
      >
        {button2Clicked ? "Datos personales" : "Datos personales"}
      </button>

      <div className="w-[360px] h-[197px] flex items-center border-2 border-[#4EA7A7] rounded-[15px] p-4 mb-4 bg-white">
        <img
          src="/src/assets/images/home/turnos.svg"
          alt="Icono"
          className="w-1/3 h-auto object-contain"
        />
        <span className="ml-4 text-lg font-semibold">Turnos</span>
      </div>

      <div className="w-[360px] h-[197px] flex items-center border-2 border-[#4EA7A7] rounded-[15px] p-4 bg-white">
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
