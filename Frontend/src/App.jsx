import { useState } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ItemForm from "./components/ItemForm";

import Dashboard from "./components/Dashboard";
// import ItemList from "./components/ItemList";
import Home from "./components/Home";
import Hello from "./components/Home2";
import Stock from "./components/Stock"; // Import the Stock component

function App() {
  const [shouldUpdateItems, setShouldUpdateItems] = useState(false);

  const handleItemAdded = () => {
    setShouldUpdateItems(true);
  };

  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<Hello />} />
        </Routes>
        <Routes>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route
            path="/inventory"
            element={
              <ItemForm
                onItemAdded={handleItemAdded}
                setShouldUpdateItems={setShouldUpdateItems}
              />
            }
          />
          <Route path="/home" element={<Home />} />
          <Route path="/stock" element={<Stock />} />{" "}
          {/* Associate /stock route with the Stock component */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
