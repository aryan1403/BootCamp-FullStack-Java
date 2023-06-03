import React, { useState } from "react";
import axios from "axios";

function ItemTable({ items, onDeleteItem, onEditItem, onItemUpdated }) {
  const [editItemId, setEditItemId] = useState(null);
  const [editItemData, setEditItemData] = useState({
    id: "",
    name: "",
    price: "",
    type: "",
    quantity: "",
  });

  const [sortColumn, setSortColumn] = useState({
    column: null,
    order: "normal",
  });

  const handleEditItem = (itemId) => {
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
      setEditItemId(null);
      setEditItemData({
        id: "",
        name: "",
        price: "",
        type: "",
        quantity: "",
      });
      onItemUpdated(); // Notify parent component that item has been updated
    } catch (error) {
      console.log(error);
    }
  };

  const cancelEditItem = () => {
    setEditItemId(null);
    setEditItemData({
      id: "",
      name: "",
      price: "",
      type: "",
      quantity: "",
    });
  };

  const handleSortColumn = (columnName) => {
    if (sortColumn.column === columnName) {
      // If same column clicked again, toggle sort order
      setSortColumn((prevSortColumn) => ({
        column: prevSortColumn.column,
        order:
          prevSortColumn.order === "ascending"
            ? "descending"
            : prevSortColumn.order === "descending"
            ? "normal"
            : "ascending",
      }));
    } else {
      // If different column clicked, set it as the new sort column in ascending order
      setSortColumn({
        column: columnName,
        order: "ascending",
      });
    }
  };

  const getSortIndicator = (columnName) => {
    if (sortColumn.column === columnName) {
      if (sortColumn.order === "ascending") {
        return "↑";
      } else if (sortColumn.order === "descending") {
        return "↓";
      }
    }
    return null;
  };

  const sortedItems = [...items]; // Create a copy of items array for sorting

  if (sortColumn.column === "price") {
    sortedItems.sort((a, b) => {
      if (sortColumn.order === "ascending") {
        return a.price - b.price;
      } else if (sortColumn.order === "descending") {
        return b.price - a.price;
      }
      return 0;
    });
  } else if (sortColumn.column === "quantity") {
    sortedItems.sort((a, b) => {
      if (sortColumn.order === "ascending") {
        return a.quantity - b.quantity;
      } else if (sortColumn.order === "descending") {
        return b.quantity - a.quantity;
      }
      return 0;
    });
  }

  return (
    <>
      <table className="item-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th
              onClick={() => handleSortColumn("price")}
              className={sortColumn.column === "price" ? sortColumn.order : ""}
            >
              Price {getSortIndicator("price")}
            </th>
            <th
              onClick={() => handleSortColumn("quantity")}
              className={
                sortColumn.column === "quantity" ? sortColumn.order : ""
              }
            >
              Quantity {getSortIndicator("quantity")}
            </th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {sortedItems.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.type}</td>
              <td>{item.price}</td>
              <td>{item.quantity}</td>
              <td>
                <button type="button" onClick={() => onDeleteItem(item.id)}>
                  Delete
                </button>
                {editItemId !== item.id && (
                  <button type="button" onClick={() => handleEditItem(item.id)}>
                    Edit
                  </button>
                )}
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
            <label>Type:</label>
            <select
              name="type"
              value={editItemData.type}
              onChange={handleEditItemChange}
            >
              <option value="">Select a type</option>
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
            </select>
            <label>Quantity:</label>
            <input
              type="text"
              name="quantity"
              value={editItemData.quantity}
              onChange={handleEditItemChange}
            />
            <label>Quantity:</label>
            <input
              type="text"
              name="quantity"
              value={editItemData.quantity}
              onChange={handleEditItemChange}
            />
          </div>
          <div className="edit-buttons">
            <button type="button" onClick={saveEditItem}>
              Save
            </button>
            <button type="button" onClick={cancelEditItem}>
              Cancel
            </button>
          </div>
        </div>
      )}
    </>
  );
}

export default ItemTable;
