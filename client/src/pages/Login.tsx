import { useAuth } from "@/hooks/useAuth";
import React, { useState } from "react";

interface FormData {
  email: string;
  contrasena: string;
}

const Login = () => {
  const [formData, setFormData] = useState<FormData>({
    email: "",
    contrasena: "",
  });
  const { login, isLoginLoading, loginError } = useAuth();
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    login({
      email: formData.email,
      password: formData.contrasena
    });
  };

  return (
    <div className="flex justify-center items-center min-h-screen w-full overflow-hidden bg-[#DCF7F9]">
      <div className="relative w-full h-screen">
        <div className="absolute inset-0 flex flex-col justify-center items-center text-center">
          <div className="max-w-2xl">
            <h3 className="text-[52px] sm:text-5xl font-bold mb-0 font-pollerone">
              <span className="text-[#4EA7A7]">MED</span>
              <span className="text-[#070258]">LIFE</span>
            </h3>
          </div>

          <form onSubmit={handleSubmit} className="space-y-4 mt-12 text-left">
            <div>
              <label htmlFor="email">Email</label>
              <div className="h-[48px] w-[320px] bg-white border border-gray-300 rounded-md shadow-sm p-2 focus:ring-2 focus:ring-blue-500 flex gap-4">
                <img src="./icons/email_icon.png" />
                <input
                  type="email"
                  id="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  required
                  placeholder="Alexdamner.1@gmail.com"
                  className="appearance-none focus:outline-none"
                />
              </div>
            </div>
            <div>
              <label htmlFor="contrasena">Contraseña</label>
              <div className="h-[48px] w-[320px] bg-white border border-gray-300 rounded-md shadow-sm p-2 focus:ring-2 focus:ring-blue-500 flex gap-4">
                <img src="./icons/password_icon.png" />
                <input
                  type="password"
                  id="contrasena"
                  name="contrasena"
                  value={formData.contrasena}
                  onChange={handleChange}
                  required
                  placeholder="************"
                  className="appearance-none focus:outline-none"
                />
              </div>
            </div>
            {loginError && (
              <p className="text-red-500 text-center">
                Error de inicio de sesión. Por favor, verifica tus credenciales.
              </p>
            )}

            <p className="text-[16px] text-center">¿Olvidaste tu contraseña?</p>
            <div className="text-center mt-24">
              <button
                type="submit"
                className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-3 px-12 rounded-[20px] transition duration-300 transform hover:scale-105 cursor-pointer"
              >
                {isLoginLoading ? 'Cargando...' : 'Ingresar'}
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
