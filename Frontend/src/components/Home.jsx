import React, { useState } from "react";
import "./item.css";
import Navbar from "./NavBar";

function Home() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Prepare the login request payload
    const loginRequest = {
      username: username,
      password: password,
    };

    // Make a POST request to the backend API
    fetch("http://localhost:8080/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(loginRequest),
    })
      .then((response) => response.text())
      .then((data) => {
        // Handle the login response
        console.log(data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <>
      <Navbar />
      <div className="container">
        <div className="image"></div>
      </div>
    </>
  );
}

export default Home;
