import React, { useState } from "react";
import axios from "axios";

export default function EditEmployeeForm(props) {
  const [name, setName] = useState("");
  const [role, setRole] = useState("");
  const [salary, setSalary] = useState("");
  const [exp, setExp] = useState("");

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleRoleChange = (e) => {
    setRole(e.target.value);
  };

  const handleSalaryChange = (e) => {
    setSalary(e.target.value);
  };

  const handleExpChange = (e) => {
    setExp(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const updatedEmployee = {
      _id: props.empId,
      name: name,
      role: role,
      salary: salary,
      exp: exp,
    };

    axios
      .post(`http://localhost:8080/editEmp/`, updatedEmployee)
      .then((response) => {
        console.log(response.data);
        alert("Employee data updated successfully!");
      })
      .catch((error) => {
        console.log(error);
        alert("Failed to update employee data");
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="form-group">
        <label>Name:</label>
        <input type="text" value={name} onChange={handleNameChange} />
      </div>
      <div className="form-group">
        <label>Role:</label>
        <input type="text" value={role} onChange={handleRoleChange} />
      </div>
      <div className="form-group">
        <label>Salary:</label>
        <input type="text" value={salary} onChange={handleSalaryChange} />
      </div>
      <div className="form-group">
        <label>Experience:</label>
        <input type="text" value={exp} onChange={handleExpChange} />
      </div>
      <button type="submit" className="btn btn-primary">
        Update
      </button>
    </form>
  );
}
