import { useState } from "react";
import { addItemToDB } from "../Service/service";
import "./testB.css";

export default function TestB() {
  const [name, setname] = useState("");
  const [purpose, setpurpose] = useState("");
  const [cost, setcost] = useState(0);
  const [warranty, setwarranty] = useState(0);

  return (
    <>
      <div className="testBdiv">
        <h3>Add Item</h3>
        <form id="itemform">
          <div className="mb-3">
            <label for="namebox" className="form-label">
              Item Name
            </label>
            <input
              type="text"
              className="form-control"
              id="namebox"
              value={name}
              onChange={(e) => setname(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <label for="purposebox" className="form-label">
              Item Purpose
            </label>
            <input
              type="text"
              className="form-control"
              id="purposebox"
              value={purpose}
              onChange={(e) => setpurpose(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <label for="costbox" className="form-label">
              Item Cost
            </label>
            <input
              type="number"
              className="form-control"
              id="costbox"
              value={cost}
              onChange={(e) => setcost(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <label for="warrantybox" className="form-label">
              Item Warranty
            </label>
            <input
              type="number"
              className="form-control"
              id="warrantybox"
              value={warranty}
              onChange={(e) => setwarranty(e.target.value)}
            />
          </div>
        </form>

        <button
          className="btn btn-primary"
          onClick={() => addItemToDB(name, purpose, cost, warranty)}
        >
          Add Item
        </button>
      </div>
    </>
  );
}
