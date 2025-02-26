import React, { useState } from "react";

interface FormData {
  dni: string;
  email: string;
  password: string;
}

const Register = () => {
  const [formData, setFormData] = useState<FormData>({
    dni: "",
    email: "",
    password: "",
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    // Validar que solo se ingresen números en el campo DNI
    if (name === "dni") {
      const numericValue = value.replace(/\D/g, "");
      setFormData({
        ...formData,
        [name]: numericValue,
      });
    } else {
      setFormData({
        ...formData,
        [name]: value,
      });
    }
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();

    console.log("Datos a enviar:", formData);

    fetch("https://backend-medlife-latest.onrender.com/api/v1/registrar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Respuesta del backend:", data);
      })
      .catch((error) => {
        console.error("Error al enviar los datos:", error);
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
          <p className="max-w-[276px] mt-12 text-[16px]">
            Para darte acceso a nuestra plataforma ingresa tus datos, valida tu
            cuenta con tu mail y contraseña.
          </p>

          <form onSubmit={handleSubmit} className="space-y-4 mt-12 text-left">
            <div>
              <label htmlFor="dni">Documento</label>
              <div className="h-[48px] w-[320px] bg-white border border-gray-300 rounded-md shadow-sm p-2 focus:ring-2 focus:ring-blue-500 flex gap-4">
                <img src="./icons/dni_icon.png" />
                <input
                  type="text"
                  id="dni"
                  name="dni"
                  value={formData.dni}
                  onChange={handleChange}
                  pattern="\d*"
                  required
                  placeholder="00.039.230"
                  className="appearance-none focus:outline-none"
                  inputMode="numeric"
                />
              </div>
            </div>
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
              <label htmlFor="password">Contraseña</label>
              <div className="h-[48px] w-[320px] bg-white border border-gray-300 rounded-md shadow-sm p-2 focus:ring-2 focus:ring-blue-500 flex gap-4">
                <img src="./icons/password_icon.png" />
                <input
                  type="password"
                  id="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                  required
                  placeholder="************"
                  className="appearance-none focus:outline-none"
                />
              </div>
            </div>
            <div className="text-center mt-24">
              <button
                type="submit"
                className="bg-[#4EA7A7] hover:bg-[#4EA7A7] text-white font-semibold py-3 px-12 rounded-[20px] transition duration-300 transform hover:scale-105 cursor-pointer"
              >
                Registrarse
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Register;
