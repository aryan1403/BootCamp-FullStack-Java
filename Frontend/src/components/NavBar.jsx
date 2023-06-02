import { Link } from "react-router-dom";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function Navbar() {
  const [activeLink, setActiveLink] = useState("");

  const handleClick = (link) => {
    setActiveLink(link);
  };
  const handleLogout = () => {
    window.location.href = "/";
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container">
        <Link
          className="navbar-brand d-flex align-items-center text-white"
          to="/"
        >
          <div
            className="rounded-circle overflow-hidden me-2"
            style={{ width: "40px", height: "40px" }}
          >
            <img
              src="https://th.bing.com/th/id/OIP.vjUPZjUMWLO_0wF71LTd7AHaHT?pid=ImgDet&rs=1"
              className="w-100 h-auto"
              alt="Flowbite Logo"
            />
          </div>
          <span className="font-weight-bold">
            {" "}
            Takeo Inventory Management System
          </span>
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ml-auto">
            <li className="nav-item">
              <Link
                className={`nav-link text-white ${
                  activeLink === "dashboard" ? "active" : ""
                }`}
                to="/dashboard"
                onClick={() => handleClick("dashboard")}
              >
                Dashboard
              </Link>
            </li>
            <li className="nav-item">
              <Link
                className={`nav-link text-white ${
                  activeLink === "inventory" ? "active" : ""
                }`}
                to="/inventory"
                onClick={() => handleClick("inventory")}
              >
                Inventory List
              </Link>
            </li>
            <li className="nav-item">
              <Link
                className={`nav-link text-white ${
                  activeLink === "stock" ? "active" : ""
                }`}
                to="/stock"
                onClick={() => handleClick("stock")}
              >
                Stock Alerts
              </Link>
            </li>
            <button type="button" className="btn btn-primary">
              Notifications <span className="badge badge-dark">4</span>
            </button>
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle text-white"
                href="#"
                id="navbarDropdownMenuLink"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <img
                  src="https://www.pngitem.com/pimgs/m/79-791921_male-profile-round-circle-users-profile-round-icon.png"
                  alt="User Avatar"
                  className="user-avatar"
                  style={{ width: "30px", height: "30px" }}
                />
              </a>

              <div
                className="dropdown-menu"
                aria-labelledby="navbarDropdownMenuLink"
              >
                <a className="dropdown-item" href="#">
                  Settings
                </a>
                <a className="dropdown-item" onClick={handleLogout} href="#">
                  Logout
                </a>
                <a className="dropdown-item" href="#">
                  Something else here
                </a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
