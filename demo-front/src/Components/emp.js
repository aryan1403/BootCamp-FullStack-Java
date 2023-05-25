import Employee from "../resources/Employee.png";
import EditEmployeeForm from "./editEmp";
import "./emp.css";
import axios from "axios";
// import { deleteEmpFromDB } from "../Service/service";

import React, { useState } from "react";

export default function Emp(props) {
  const [editMode, setEditMode] = useState(false);

  const handleEditEmp = () => {
    setEditMode(true);
  };

  const handleDeleteEmp = () => {
    const demp = {
      _id: props.empId,
      name: props.empName,
      post: props.empDesc,
    };
    console.log(demp);
    axios
      .delete("http://localhost:8080/delEmp", { data: demp })
      .then((response) => {
        console.log(response);
        alert("Deleted Successfully");
      })
      .catch((error) => {
        console.log(error);
        alert("Failed to delete employee");
      });
  };

  return (
    <>
      {editMode ? (
        <EditEmployeeForm
          empId={props.empId}
          empName={props.empName}
          empDesc={props.empDesc}
        />
      ) : (
        <div className="card">
          <img src={Employee} className="card-img-top" alt="..." />
          <div className="card-body">
            <h5 className="card-title">{props.empName}</h5>
            <p className="card-text">{props.empDesc}</p>
            <button className="btn btn-success" onClick={handleEditEmp}>
              Edit
            </button>
            <button className="btn btn-danger" onClick={handleDeleteEmp}>
              Delete
            </button>
          </div>
        </div>
      )}
    </>
  );
}
