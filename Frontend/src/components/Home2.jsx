import React, { useState } from "react";
import "./item.css";

function Hello() {
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

        // Check if login is successful and redirect to home page
        if (data === "Login successful") {
          window.location.href = "/home";
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <>
      <div className="container">
        <div className="image">
          <div className="container d-flex justify-content-center align-items-center vh-100">
            <form
              style={{ width: "30%", height: "50%" }}
              onSubmit={handleSubmit}
            >
              <div className="form-outline mb-4">
                <input
                  type="text"
                  id="form2Example1"
                  className="form-control"
                  value={username}
                  onChange={handleUsernameChange}
                />
                <label className="form-label" htmlFor="form2Example1">
                  Username
                </label>
              </div>

              <div className="form-outline mb-4">
                <input
                  type="password"
                  id="form2Example2"
                  className="form-control"
                  value={password}
                  onChange={handlePasswordChange}
                />
                <label className="form-label" htmlFor="form2Example2">
                  Password
                </label>
              </div>

              <div className="row mb-4">
                <div className="col d-flex justify-content-center">
                  <div className="form-check">
                    <input
                      className="form-check-input"
                      type="checkbox"
                      value=""
                      id="form2Example31"
                      checked
                    />
                    <label
                      className="form-check-label"
                      htmlFor="form2Example31"
                    >
                      Remember me
                    </label>
                  </div>
                </div>

                <div className="col">
                  <a href="#!">Forgot password?</a>
                </div>
              </div>

              <button type="submit" className="btn btn-primary btn-block mb-4">
                Sign in
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default Hello;
