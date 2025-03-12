import { useState } from "react";
import { useParams, Link } from "react-router-dom";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";

type ValuePiece = Date | null;
type Value = ValuePiece | [ValuePiece, ValuePiece];

const ScheduleCalendar = () => {
  const { doctorName } = useParams<{ doctorName: string }>();
  const [date, setDate] = useState<Value>(new Date());
  const [selectedTime, setSelectedTime] = useState<string>("");

  const timeSlots = ["09:00", "10:00", "11:00", "14:00", "15:00", "16:00"];

  const handleSubmit = () => {
    console.log("doctor:", doctorName);
    console.log("fecha:", date);
    console.log("hora:", selectedTime);
  };

  return (
    <div className="h-full bg-white p-8 max-w-4xl mx-auto pb-32 md:pb-0">
      <Link
        to="/schedule-appointments"
        className="text-[#4EA7A7] hover:underline mb-8 inline-block"
      >
        ← Volver atrás
      </Link>

      <h2 className="text-3xl font-bold text-[#4EA7A7] mb-8">
        Reservar cita con {decodeURIComponent(doctorName || "")}
      </h2>

      <div className="grid md:grid-cols-2 gap-8">
        <div>
          <Calendar
            onChange={setDate}
            value={date}
            minDate={new Date()}
            className="border-[#4EA7A7] rounded-lg p-4"
          />
        </div>

        <div>
          <h3 className="text-xl font-semibold mb-4 text-[#4EA7A7]">
            Selecciona un horario
          </h3>

          <div className="grid grid-cols-2 gap-4">
            {timeSlots.map((time) => (
              <button
                key={time}
                onClick={() => setSelectedTime(time)}
                className={`p-3 rounded-lg border ${
                  selectedTime === time
                    ? "bg-[#4EA7A7] text-white border-[#4EA7A7]"
                    : "bg-[#4EA7A7]/10 border-[#4EA7A7] hover:bg-[#4EA7A7]/20"
                }`}
              >
                {time}
              </button>
            ))}
          </div>

          {selectedTime && date && (
            <div className="mt-8">
              <button
                onClick={handleSubmit}
                className="w-full bg-[#4EA7A7] text-white py-3 rounded-lg hover:bg-[#4EA7A7]/90 transition-colors"
              >
                Confirmar cita el {(date as Date).toLocaleDateString()} a las{" "}
                {selectedTime}
              </button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default ScheduleCalendar;
