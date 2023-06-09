import axios from "axios";

const URL = 'http://localhost:8080';

export async function addEmpToDB(name, role, salary, exp) {
    const data = {
        name: name,
        role: role,
        salary: salary,
        exp: exp
    };
    return await axios.post(URL + '/addEmp', data).then(res => {
        console.log(res.data);

        alert(res.data.msg);
        return res.data;
    })
}

export async function updateEmpToDb(id, name, role, salary, exp) {
    const data = {
        _id: id,
        name: name,
        role: role,
        salary: salary,
        exp: exp
    };
    return await axios.post(URL + '/updateEmp', data).then(res => {
        console.log(res.data);

        alert(res.data.msg);
        return res.data;
    })
}

export async function getAllEmp() {
    return await axios.get(URL + '/getEmp').then(res => {
        const emps = res.data.data;
        return emps;
    });
}

export async function deleteEmp(emp) {
    return await axios.post(URL + '/deleteEmp', emp).then(res => {return res.data});
}