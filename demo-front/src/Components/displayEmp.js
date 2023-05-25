import { useEffect, useState } from "react";
import { getAllEmp } from "../Service/service";
import Emp from "./emp";
import "./displayEmp.css";

export default function DisplayEmp() {
  const [emps, setemps] = useState([]);

  useEffect(() => {
    getAllEmp().then((data) => {
      //console.log(data);
      setemps(data);
    });
  }, []);

  return (
    <>
      {
        <div className="row">
          {/* <Emp empName={"San"} empDesc={"nsm"}></Emp>; */}
          {emps.map((emp) => {
            return (
              <Emp empId={emp._id} empName={emp.name} empDesc={emp.role}></Emp>
            );
          })}
        </div>
      }
    </>
  );
}
