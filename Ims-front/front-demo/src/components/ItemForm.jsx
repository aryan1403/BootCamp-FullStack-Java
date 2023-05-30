import { useState } from "react";
import axios from "axios";

function ItemForm({ onItemAdded }) {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");

  const addItem = async () => {
    const newItem = {
      id: id,
      name: name,
      price: price,
      quantity: quantity,
    };

    try {
      await axios.post("http://localhost:8080/item", newItem);
      setId("");
      setName("");
      setPrice("");
      setQuantity("");
      onItemAdded(); // Invoke the callback to fetch the updated item list
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <form>
      <label>ID:</label>
      <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
      <label>Name:</label>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <label>Price:</label>
      <input
        type="text"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />
      <label>Quantity:</label>
      <input
        type="text"
        value={quantity}
        onChange={(e) => setQuantity(e.target.value)}
      />
      <button type="button" onClick={addItem}>
        Add Item
      </button>
    </form>
  );
}

export default ItemForm;
