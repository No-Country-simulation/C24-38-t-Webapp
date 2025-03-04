const AuthScreen = () => {
  return (
    <div className="flex justify-center items-center min-h-screen w-full overflow-hidden bg-[#DCF7F9]">
      <div className="relative w-full h-screen">
        <div className="absolute w-[120%] h-[180px] -top-[96px] left-1/2 transform -translate-x-1/2 bg-white rounded-[100%]" />

        <div className="absolute inset-0 flex flex-col justify-center items-center text-center">
          <div className="max-w-2xl">
            <h3 className="text-[52px] sm:text-5xl font-bold mb-0 font-pollerone">
              <span className="text-[#4EA7A7]">MED</span>
              <span className="text-[#070258]">LIFE</span>
            </h3>
          </div>
          <div className="mt-12">
            <button className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-3 px-12 rounded-[20px] transition duration-300 transform hover:scale-105">
              Iniciar sesión
            </button>
          </div>
          <div className="mt-12">
            <button className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-3 px-12 rounded-[20px] transition duration-300 transform hover:scale-105">
              Registrarse
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AuthScreen;
