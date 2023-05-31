import { Link } from "react-router-dom";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function Navbar() {
  const [activeLink, setActiveLink] = useState("");
  const [searchQuery, setSearchQuery] = useState("");

  const handleClick = (link) => {
    setActiveLink(link);
  };

  const handleSearchChange = (e) => {
    setSearchQuery(e.target.value);
  };

  const handleSearchSubmit = (e) => {
    e.preventDefault();
    // Perform search functionality with the searchQuery
    console.log("Search Query:", searchQuery);
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container-fluid">
        <Link className="navbar-brand text-white" to="/">
          Inventory Management System
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
          </ul>
          <form className="d-flex" onSubmit={handleSearchSubmit}>
            <input
              className="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
              value={searchQuery}
              onChange={handleSearchChange}
            />
            <button className="btn btn-outline-light" type="submit">
              Search
            </button>
          </form>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
