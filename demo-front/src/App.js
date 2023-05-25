import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import DisplayEmp from './Components/displayEmp';
import EditEmp from './Components/editemp';
import NavBar from './Components/NavBar';
import TestB from './Components/testB';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/edit/*' element={<EditEmp/>}/>
      <Route path='/' element={<DisplayEmp/>}/>
      <Route path='/addEmp' element={<TestB/>}/>
    </Routes>
    </BrowserRouter>    
  );
}

export default App;
