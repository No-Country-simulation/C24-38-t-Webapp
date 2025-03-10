import { Routes, Route, useLocation } from "react-router-dom";
import AuthScreen from "./pages/AuthScreen";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Home from "./pages/Home";
import WelcomeScreen from "./pages/WelcomeScreen";
import Menu from "./components/Menu";
import MedicalHistory from "./pages/MedicalHistory";
import ScheduleAppointments from "./pages/ScheduleAppointments";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import ScheduleCalendar from "./pages/ScheduleCalendar";
import ClinicalHistory from "./pages/clinicalHistory";

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      staleTime: 1000 * 60 * 5,
      refetchOnWindowFocus: false,
    },
  },
});
export default function App() {
  const location = useLocation();

  const noMenuRoutes = ["/login", "/register", "/auth", "/"];

  const showMenu = !noMenuRoutes.includes(location.pathname);

  return (
    <QueryClientProvider client={queryClient}>
      {showMenu && <Menu />}
      <Routes>
        <Route path="/" element={<WelcomeScreen />} />
        <Route path="/auth" element={<AuthScreen />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/clinical-history" element={<ClinicalHistory />} />
        <Route path="/medical-history" element={<MedicalHistory />} />
        <Route
          path="/schedule-appointments"
          element={<ScheduleAppointments />}
        />
        <Route path="/schedule/:doctorName" element={<ScheduleCalendar />} />
      </Routes>
    </QueryClientProvider>
  );
}
