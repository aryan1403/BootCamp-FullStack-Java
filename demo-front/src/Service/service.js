import axios from "axios";

const URL = 'http://localhost:8080';

export function addEmpToDB(name, role, salary, exp) {
    const data = {
        name: name,
        role: role,
        salary: salary,
        exp: exp
    };
    axios.post(URL + '/addEmp', data).then(res => {
        console.log(res.data);

        alert(res.data.msg);
        return res.data;
    })
}