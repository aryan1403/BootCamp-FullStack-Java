import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import Navbar from "./components/Navbar";
import ItemForm from "./components/ItemForm";
import Dashboard from "./components/Dashboard";
import Home from "./components/Home";
import Hello from "./components/Login";
import Stock from "./components/Stock";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [shouldUpdateItems, setShouldUpdateItems] = useState(false);
  const [alertCount, setAlertCount] = useState(0);

  useEffect(() => {
    // Check if the login state is stored in localStorage
    const storedLoginState = localStorage.getItem("isLoggedIn");
    if (storedLoginState) {
      setIsLoggedIn(JSON.parse(storedLoginState));
    }
  }, []);

  const handleItemAdded = () => {
    setShouldUpdateItems(true);
  };

  const handleLogin = (username, password, navigate) => {
    if (username === "admin" && password === "password") {
      setIsLoggedIn(true);
      localStorage.setItem("isLoggedIn", JSON.stringify(true)); // Store the login state in localStorage
      navigate("/home");
    } else {
      alert("Invalid username or password");
    }
  };

  const handleShouldUpdateItems = (value) => {
    setShouldUpdateItems(value);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    localStorage.removeItem("isLoggedIn"); // Remove the login state from localStorage
  };

  return (
    <Router>
      <div>
        <Navbar alertCount={alertCount} />
        <Routes>
          <Route path="/" element={<Hello onLogin={handleLogin} />} />
          {isLoggedIn && (
            <Route
              path="/home"
              element={<Home onLogout={handleLogout} alertCount={alertCount} />}
            />
          )}
          {isLoggedIn && (
            <Route
              path="/inventory"
              element={
                <ItemForm
                  onItemAdded={handleItemAdded}
                  setShouldUpdateItems={handleShouldUpdateItems}
                  setAlertCount={setAlertCount}
                />
              }
            />
          )}
          {isLoggedIn && (
            <Route
              path="/stock"
              element={
                <Stock
                  setShouldUpdateItems={handleShouldUpdateItems}
                  setAlertCount={setAlertCount}
                />
              }
            />
          )}
          {isLoggedIn && (
            <Route
              path="/dashboard"
              element={<Dashboard setAlertCount={setAlertCount} />}
            />
          )}
          {!isLoggedIn && <Route path="/*" element={<Navigate to="/" />} />}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
