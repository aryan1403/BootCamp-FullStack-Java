import { useState, useEffect } from "react";
import axios from "axios";
import "./item.css";

function ItemList() {
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

  const deleteItem = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/items/${id}`);
      fetchItems();
    } catch (error) {
      console.log(error);
    }
  };

  const openEditModal = (item) => {
    setEditItemId(item.id);
    setEditItemData(item);
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

  const handleEditItemChange = (e) => {
    const { name, value } = e.target;
    setEditItemData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const saveEditItem = async () => {
    try {
      await axios.put(
        `http://localhost:8080/items/${editItemId}`,
        editItemData
      );
      fetchItems();
      closeEditModal();
    } catch (error) {
      console.log(error);
    }
  };

  return (
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
              <button type="button" onClick={() => openEditModal(item)}>
                Edit
              </button>
            </td>
          </tr>
        ))}
      </tbody>

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
    </table>
  );
}

export default ItemList;
