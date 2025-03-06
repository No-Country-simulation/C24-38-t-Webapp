import { Link } from "react-router-dom";

const MedicalHistory = () => {
  return (
    <div className="flex justify-center items-center min-h-screen w-full overflow-hidden bg-white pb-24 md:pb-0">
      <div className="relative w-full h-screen">
        <div className="absolute inset-0 flex flex-col md:items-center p-4">
          <div className="max-w-2xl space-y-12 text-lg">
            <h3 className="text-2xl font-bold mb-4 text-[#4EA7A7]">
              Antecedentes medicos:
            </h3>
            <h3 className="text-xl font-bold mb-2">
              Enfermedades preexistentes:
            </h3>
            <div className="space-y-2">
              <p>Fecha de diagnóstico: 11/07/2023</p>
              <p>✅Hipertensión</p>
              <p>Fecha de diagnóstico: 5/03/2024</p>
              <p>✅Diabetes</p>
            </div>
            <div className="space-y-2">
              <h3 className="font-bold">Alergias:</h3>

              <p>Fecha de diagnóstico: 3/07/2022</p>
              <p>✅Medicamentos: Ibuprofeno</p>
            </div>
            <div className="space-y-2">
              <h3 className="font-bold">Cirugías previas:</h3>
              <p>Ninguna</p>
            </div>
          </div>

          <div className="mt-12 text-center">
            <button className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-4 px-12 rounded-[10px] transition duration-300 transform hover:scale-105 text-lg">
              PDF historia clínica
            </button>
          </div>
          <div className="mt-12 text-center">
            <Link to={"/schedule-appointments"} className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-4 px-12 rounded-[10px] transition duration-300 transform hover:scale-105 text-lg">
              Reservar turno
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MedicalHistory;
