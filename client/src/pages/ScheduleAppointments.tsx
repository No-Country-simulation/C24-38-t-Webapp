import { Link } from "react-router-dom";

const ScheduleAppointments = () => {
  return (
    <div className="flex justify-center items-center min-h-screen w-full overflow-hidden bg-white">
      <div className="relative w-full h-screen">
        <div className="absolute inset-0 flex flex-col md:items-center p-4">
          <div className="max-w-2xl space-y-12 text-lg">
            <h3 className="text-2xl font-bold mb-4 text-[#4EA7A7]">
              Programar Turnos
            </h3>

            <div className="mt-12 text-center flex justify-center">
              <button className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-4 px-12 rounded-[10px] transition duration-300 transform hover:scale-105 text-lg flex justify-center items-center gap-2">
                <img
                  src="./icons/search.svg"
                  alt="search"
                  className="h-6 w-6"
                />
                <span>Encontra tu especialista</span>
              </button>
            </div>

            <div className="flex justify-center items-center flex-col gap-4">
              <button className="rounded-xl bg-[#4EA7A7]/10 border border-[#4EA7A7] w-full max-w-[200px] py-2 text-lg">
                Dr. García
              </button>
              <button className="rounded-xl bg-[#4EA7A7]/10 border border-[#4EA7A7] w-full max-w-[200px] py-2 text-lg">
                Dr. Stefano
              </button>
            </div>

            <div className="rounded-xl bg-[#4EA7A7]/10 border border-[#4EA7A7] w-full p-8 text-lg flex flex-col justify-center items-center space-y-4">
              <div>
                <img
                  src="./consulting.jpg"
                  alt="search"
                  className="h-24 w-24"
                />
              </div>
              <div className="text-center">
                <h3 className="font-bold">Tu Citas:</h3>
                <span>Dr Stefano: 28/06/2025</span>
                <span>15:15</span>
                <span>Brown 5633</span>
              </div>
              <button>Ver más..</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ScheduleAppointments;
