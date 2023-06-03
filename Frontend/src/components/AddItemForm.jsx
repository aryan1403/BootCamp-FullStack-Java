import { useState } from "react";

function AddItemForm({ onItemAdded }) {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [type, setType] = useState("");
  const [quantity, setQuantity] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const addItem = () => {
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

    onItemAdded(newItem);

    // Reset form fields
    setId("");
    setName("");
    setPrice("");
    setType("");
    setQuantity("");
    setErrorMessage("");
  };

  return (
    <form className="form-container">
      <div className="form-row">
        <label>ID:</label>
        <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
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
        <input
          type="text"
          value={type}
          onChange={(e) => setType(e.target.value)}
        />
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
  );
}

export default AddItemForm;
