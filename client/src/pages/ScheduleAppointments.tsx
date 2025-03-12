import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const ScheduleAppointments = () => {
  const [showModal, setShowModal] = useState(false);
  const [doctors, setDoctors] = useState<string[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (showModal) {
    
      fetch('https://backend-medlife-production.up.railway.app/api/v1/medicos/listarPorNombre')
        .then((response) => response.json())
        .then((data) => setDoctors(data)) 
        .catch((error) => console.error("Error fetching doctors:", error));
    }
  }, [showModal]);

  const handleDoctorSelect = (doctor: string) => {
    navigate(`/schedule/${encodeURIComponent(doctor)}`);
    setShowModal(false);
  };

  return (
    <div className="flex justify-center items-center min-h-screen w-full overflow-hidden bg-white">
      <div className="relative w-full h-screen">
        <div className="absolute inset-0 flex flex-col md:items-center p-4">
          <div className="max-w-2xl space-y-12 text-lg">
            <h3 className="text-2xl font-bold mb-4 text-[#4EA7A7]">
              Programar Turnos
            </h3>

            <div className="mt-12 text-center flex justify-center">
              <button
                onClick={() => setShowModal(true)}
                className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-4 px-12 rounded-[10px] transition duration-300 transform hover:scale-105 text-lg flex justify-center items-center gap-2"
              >
                <img
                  src="./icons/search.svg"
                  alt="search"
                  className="h-6 w-6"
                />
                <span>Encontrar tu especialista</span>
              </button>
            </div>

            {/* Modal */}
            {showModal && (
              <div className="fixed inset-0 bg-black/80 h-full bg-opacity-50 flex items-center justify-center z-50">
                <div className="bg-white rounded-xl p-6 w-full max-w-md mx-4">
                  <div className="flex justify-between items-center mb-4">
                    <h3 className="text-xl font-bold text-[#4EA7A7]">
                      Selecciona un médico
                    </h3>
                    <button
                      onClick={() => setShowModal(false)}
                      className="text-gray-500 hover:text-gray-700"
                    >
                      ✕
                    </button>
                  </div>

                  <div className="max-h-60 overflow-y-auto">
                    {doctors.map((doctor, index) => (
                      <button
                        key={index} // Usamos el índice como clave
                        onClick={() => handleDoctorSelect(doctor)}
                        className="w-full p-3 mb-2 text-left rounded-lg bg-[#4EA7A7]/10 hover:bg-[#4EA7A7]/20 transition-colors border border-[#4EA7A7]"
                      >
                        {doctor}
                      </button>
                    ))}
                  </div>
                </div>
              </div>
            )}

            <div className="rounded-xl bg-[#4EA7A7]/10 border border-[#4EA7A7] w-full p-8 text-lg flex flex-col justify-center items-center space-y-4">
              <div>
                <img
                  src="./consulting.jpg"
                  alt="search"
                  className="h-24 w-24 rounded-full"
                />
              </div>
              <div className="text-center space-y-2">
                <h3 className="font-bold">Tu Citas:</h3>
                <p>Dr Stefano: 28/06/2025</p>
                <p>15:15</p>
                <p>Brown 5633</p>
              </div>
              <button className="text-[#4EA7A7] hover:underline mt-4">
                Ver más..
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ScheduleAppointments;