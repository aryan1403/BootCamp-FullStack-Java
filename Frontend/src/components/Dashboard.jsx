// Dashboard.js
import React, { useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import Navbar from "./NavBar";
import "./item.css";

function Dashboard() {
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    if (location.pathname === "/dashboard") {
      console.log("Dashboard page");
    } else {
      navigate("/"); // Redirect to login page if not logged in
    }
  }, [location, navigate]);

  return (
    <div className="image">
      {/* <Navbar /> */}
      <h1>Dashboard</h1>
      {/* Your dashboard content */}
    </div>
  );
}

export default Dashboard;
