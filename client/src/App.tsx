import { Routes, Route, useLocation } from "react-router-dom";
import AuthScreen from "./pages/AuthScreen";
import Login from "./pages/Login";
import Register from "./pages/Register";
import WelcomeScreen from "./pages/WelcomeScreen";
import Menu from "./components/Menu";
import MedicalHistory from "./pages/MedicalHistory";
import ScheduleAppointments from "./pages/ScheduleAppointments";

export default function App() {
  const location = useLocation();

  const noMenuRoutes = ["/login", "/register", ""];

  const showMenu = !noMenuRoutes.includes(location.pathname);

  return (
    <>
      {showMenu && <Menu />}
      <Routes>
        <Route path="/" element={<WelcomeScreen />} />
        <Route path="/auth" element={<AuthScreen />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/medical-history" element={<MedicalHistory />} />
        <Route path="/schedule-appointments" element={<ScheduleAppointments />} />
      </Routes>
    </>
  );
}