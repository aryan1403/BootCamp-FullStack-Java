import { useEffect, useState } from "react";
import { getAllEmp } from "../Service/service";
import Emp from "./emp";
import './displayEmp.css';

export default function DisplayEmp() {
  const [emps, setemps] = useState([]);
  
  useEffect(() => {
    getAllEmp().then((data) => {
      setemps(data);
    });
  }, []);

  return (
    <>
    {
        <div className="row">

            {emps.map(emp => {return <Emp empName={emp.name} empDesc={emp.role}></Emp>})}
        </div>
    }
    </>
  );
}
