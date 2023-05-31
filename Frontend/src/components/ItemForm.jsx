import { useState, useEffect } from "react";
import axios from "axios";
import "./item.css";

function ItemForm({ onItemAdded, setShouldUpdateItems }) {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [items, setItems] = useState([]);
  const [editItemId, setEditItemId] = useState(null);
  const [editItemData, setEditItemData] = useState({
    id: "",
    name: "",
    price: "",
    quantity: "",
  });

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
      quantity: quantity,
    };

    try {
      await axios.post("http://localhost:8080/item", newItem);
      setId("");
      setName("");
      setPrice("");
      setQuantity("");
      setErrorMessage("");
      onItemAdded();
      setShouldUpdateItems(true);
      setItems([...items, newItem]);
    } catch (error) {
      console.log(error);
    }
  };

  const deleteItem = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/items/${id}`);
      fetchItems();
    } catch (error) {
      console.log(error);
    }
  };

  const editItem = (itemId) => {
    const itemToEdit = items.find((item) => item.id === itemId);
    setEditItemId(itemId);
    setEditItemData(itemToEdit);
  };

  const handleEditItemChange = (e) => {
    const { name, value } = e.target;
    setEditItemData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const saveEditItem = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/items/${editItemId}`,
        editItemData
      );
      console.log("Item updated:", response.data);
      fetchItems();
    } catch (error) {
      console.log(error);
    }

    // Clear the edit state
    setEditItemId(null);
    setEditItemData({
      id: "",
      name: "",
      price: "",
      quantity: "",
    });
  };

  const closeEditModal = () => {
    setEditItemId(null);
    setEditItemData({
      id: "",
      name: "",
      price: "",
      quantity: "",
    });
  };

  const renderItemsTable = () => {
    if (items.length === 0) {
      return null;
    }

    return (
      <>
        <table className="item-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Price</th>
              <th>Quantity</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.price}</td>
                <td>{item.quantity}</td>
                <td>
                  <button type="button" onClick={() => deleteItem(item.id)}>
                    Delete
                  </button>
                  <button type="button" onClick={() => editItem(item.id)}>
                    Edit
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        {editItemId !== null && (
          <div className="edit-modal">
            <div className="edit-modal-content">
              <h2>Edit Item</h2>
              <label>ID:</label>
              <input
                type="text"
                name="id"
                value={editItemData.id}
                onChange={handleEditItemChange}
              />
              <label>Name:</label>
              <input
                type="text"
                name="name"
                value={editItemData.name}
                onChange={handleEditItemChange}
              />
              <label>Price:</label>
              <input
                type="text"
                name="price"
                value={editItemData.price}
                onChange={handleEditItemChange}
              />
              <label>Quantity:</label>
              <input
                type="text"
                name="quantity"
                value={editItemData.quantity}
                onChange={handleEditItemChange}
              />
              <button type="button" onClick={saveEditItem}>
                Save
              </button>
              <button type="button" onClick={closeEditModal}>
                Cancel
              </button>
            </div>
          </div>
        )}
      </>
    );
  };

  return (
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

      {renderItemsTable()}
    </div>
  );
}

export default ItemForm;
