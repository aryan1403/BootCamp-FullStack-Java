import React, { useState, useEffect } from "react";
import axios from "axios";
import "./item.css";
import Navbar from "./NavBar";
import ItemTable from "./ItemTable";

function ItemForm() {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [type, setType] = useState("");
  const [quantity, setQuantity] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [items, setItems] = useState([]);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = async () => {
    try {
      const response = await axios.get("http://localhost:8080/items");
      setItems(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const addItem = async () => {
    if (!id || !name || !price || !quantity) {
      setErrorMessage("Please fill out all fields");
      return;
    }

    const newItem = {
      id: id,
      name: name,
      price: price,
      type: type,
      quantity: quantity,
    };

    try {
      await axios.post("http://localhost:8080/item", newItem);
      setId("");
      setName("");
      setPrice("");
      setType("");
      setQuantity("");
      setErrorMessage("");
      setItems([...items, newItem]);
    } catch (error) {
      console.log(error);
    }
  };

  const deleteItem = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/items/${id}`);
      setItems(items.filter((item) => item.id !== id));
    } catch (error) {
      console.log(error);
    }
  };

  const handleItemUpdated = () => {
    fetchItems();
  };

  return (
    <>
      {/* <Navbar /> */}
      <div className="image"></div>
      <div className="container-1">
        <h2>Add a new Item</h2>
        <form className="form-container">
          <div className="form-row">
            <label>ID:</label>
            <input
              type="text"
              value={id}
              onChange={(e) => setId(e.target.value)}
            />
          </div>
          <div className="form-row">
            <label>Name:</label>
            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div className="form-row">
            <label>Price:</label>
            <input
              type="text"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            />
          </div>
          <div className="form-row">
            <label>Type:</label>
            <select value={type} onChange={(e) => setType(e.target.value)}>
              <option value="">Select a type</option>
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
            </select>
          </div>

          <div className="form-row">
            <label>Quantity:</label>
            <input
              type="text"
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
            />
          </div>
          <button type="button" onClick={addItem}>
            Add Item
          </button>
          {errorMessage && <p>{errorMessage}</p>}
        </form>
        <ItemTable
          items={items}
          onDeleteItem={deleteItem}
          onItemUpdated={handleItemUpdated}
        />
      </div>
    </>
  );
}

export default ItemForm;
