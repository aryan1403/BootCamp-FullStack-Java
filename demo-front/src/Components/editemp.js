import { useState } from "react";
import { Link } from "react-router-dom";
import { updateEmpToDb } from "../Service/service";
import './testB.css';


export default function EditEmp(props) {
    const empId = window.location.href.split("/")[4];
    
    const [name, setname] = useState('');
    const [role, setrole] = useState('');
    const [salary, setsalary] = useState(0);
    const [exp, setexp] = useState(0);

    return (
        <>
        <div className='testBdiv'>
            <h3>Update Employee</h3>
            <form id='empform'>
                <div className="mb-3">
                    <label for="namebox" className="form-label">Employee Full Name</label>
                    <input type="text" className="form-control" id="namebox" value={name} onChange={(e) => setname(e.target.value)}/>
                </div>
                <div className="mb-3">
                    <label for="rolebox" className="form-label">Employee Role</label>
                    <input type="text" className="form-control" id="rolebox" value={role} onChange={(e) => setrole(e.target.value)}/>
                </div>
                <div className="mb-3">
                    <label for="salarybox" className="form-label">Employee Salary</label>
                    <input type="number" className="form-control" id="salarybox" value={salary} onChange={(e) => setsalary(e.target.value)}/>
                </div>
                <div className="mb-3">
                    <label for="expbox" className="form-label">Employee Experience</label>
                    <input type="number" className="form-control" id="expbox" value={exp} onChange={(e) => setexp(e.target.value)}/>
                </div>
            </form>
        <Link to='/'>
            <button className="btn btn-success" onClick={() => updateEmpToDb(empId, name, role, salary, exp)}>Update Employee</button>
        </Link>
        </div>
        </>
    );
}