import { Link } from "react-router-dom";
import "../assets/styles/menu.css";

const Menu = () => {
  return (
    <nav className="menu-container">
      <div className="menu-box">
        <Link to="/page1" className="menu-item">
          <img src="/icons/client_menu.svg" alt="Página 1" />
        </Link>
        <Link to="/page2" className="menu-item">
          <img src="/icons/ambulance_menu.svg" alt="Página 2" />
        </Link>
        
        <Link to="/emergency" className="menu-item emergency">
          <img src="/icons/emergency_menu.svg" alt="Emergencia" />
        </Link>

        <Link to="/page3" className="menu-item">
          <img src="/icons/home_menu.svg" alt="Página 3" />
        </Link>
        <Link to="/page4" className="menu-item">
          <img src="/icons/config_menu.svg" alt="Página 4" />
        </Link>
      </div>
    </nav>
  );
};

export default Menu;
