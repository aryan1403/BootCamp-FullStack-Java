import { Link } from "react-router-dom";
import Employee from "../resources/Employee.png";
import { deleteEmp } from "../Service/service";
import './emp.css';
export default function Emp(props) {
    function DeleteEmp() {
        console.log("hey");
        const demp = {
            _id: props.empId,
            name: props.empName,
            role: props.empDesc,
            salary: props.empSalary,
            exp: props.empExp
        };

        deleteEmp(demp).then(res => {
            alert(res.msg);
        });
    }
    return (
        <>
        <div className="card">
        <img src={Employee} className="card-img-top" alt="..."/>
        <div className="card-body">
            <h5 className="card-title">{props.empName}</h5>
            <p className="card-text">{props.empDesc}</p>
            <Link to={'/edit/'+props.empId} className="btn btn-success">Edit</Link>
            <button onClick={() => DeleteEmp()} className="btn btn-danger">Delete</button>
        </div>
        </div>
        </>
    );
}