import React from "react";
import { Link, useNavigate } from "react-router-dom";

export default function ClinicalHistory() {
  const navigate = useNavigate();

  return (
    <div className="flex flex-col items-center justify-start min-h-screen bg-gray-100 p-4 overflow-y-auto space-y-4">
      <div className="max-w-2xl space-y-12 text-lg">
        <h3 className="text-2xl font-bold mb-4 text-[#4EA7A7]">
          Historial Clínico
        </h3>
        <div className="space-y-2">
          <p>
            En esta sección puedes acceder al historial clinico, tambien cargar
            y descargar documentos.
          </p>
        </div>
      </div>

      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-4"
        onClick={() => navigate("/medical-history")}
      >
        Antecendentes medicos
      </button>
      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-8"
        onClick={() => navigate("/")}
      >
        Diagnosticos previos
      </button>
      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-8"
        onClick={() => navigate("/")}
      >
        Tratamientos
      </button>
      <button
        className="w-[279px] h-[79px] bg-[#4EA7A7] text-white text-lg rounded-[10px] border border-gray-200 mb-8"
        onClick={() => navigate("/")}
      >
        Medicación actual
      </button>

      <div className="space-y-2 text-center text-[#4EA7A7] w-full max-w-[300px]">
        <p>
          Estas funcionalidades garantizan una gestión integral y eficiente de
          la información médica, facilitando una atención personalizada y de
          calidad.
        </p>
      </div>
    </div>
  );
}
