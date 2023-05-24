import Employee from "../resources/Employee.png";
import './emp.css';
export default function Emp(props) {
    return (
        <>
        <div className="card">
        <img src={Employee} className="card-img-top" alt="..."/>
        <div className="card-body">
            <h5 className="card-title">{props.empName}</h5>
            <p className="card-text">{props.empDesc}</p>
            <a href="/" className="btn btn-success">Edit</a>
            <a href="/" className="btn btn-danger">Delete</a>
        </div>
        </div>
        </>
    );
}