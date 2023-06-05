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
  const [dispatchItemId, setDispatchItemId] = useState(null);
  const [dispatchQuantity, setDispatchQuantity] = useState("");
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

  const handleDispatchItem = (itemId) => {
    setDispatchItemId(itemId);
    setDispatchQuantity("");
  };

  const handleDispatchQuantityChange = (e) => {
    setDispatchQuantity(e.target.value);
  };

  const dispatchItem = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/items/${dispatchItemId}/dispatch`,
        { dispatchQuantity }
      );
      console.log("Item dispatched:", response.data);
      setDispatchItemId(null);
      setDispatchQuantity("");
      onItemUpdated(); // Notify parent component that item has been updated
    } catch (error) {
      console.log("Dispatch error:", error);
      console.log("Response data:", error.response.data);
      console.log("Response status:", error.response.status);
      console.log("Response headers:", error.response.headers);
    }
  };

  const sortedItems = items.sort((a, b) => {
    if (sortColumn.column === "price") {
      const priceA = parseFloat(a.price);
      const priceB = parseFloat(b.price);
      if (sortColumn.order === "ascending") {
        return priceA - priceB;
      } else if (sortColumn.order === "descending") {
        return priceB - priceA;
      }
    } else if (sortColumn.column === "quantity") {
      const quantityA = parseInt(a.quantity);
      const quantityB = parseInt(b.quantity);
      if (sortColumn.order === "ascending") {
        return quantityA - quantityB;
      } else if (sortColumn.order === "descending") {
        return quantityB - quantityA;
      }
    }
    return 0;
  });

  return (
    <div>
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
                <button
                  type="button"
                  onClick={() => handleDispatchItem(item.id)}
                >
                  Dispatch
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {editItemId && (
        <div className="edit-item-form">
          <h3>Edit Item</h3>
          <form>
            <label htmlFor="edit-name">Name:</label>
            <input
              type="text"
              id="edit-name"
              name="name"
              value={editItemData.name}
              onChange={handleEditItemChange}
            />

            <label htmlFor="edit-type">Type:</label>
            <input
              type="text"
              id="edit-type"
              name="type"
              value={editItemData.type}
              onChange={handleEditItemChange}
            />

            <label htmlFor="edit-price">Price:</label>
            <input
              type="number"
              id="edit-price"
              name="price"
              value={editItemData.price}
              onChange={handleEditItemChange}
            />

            <label htmlFor="edit-quantity">Quantity:</label>
            <input
              type="number"
              id="edit-quantity"
              name="quantity"
              value={editItemData.quantity}
              onChange={handleEditItemChange}
            />

            <button type="button" onClick={saveEditItem}>
              Save
            </button>
            <button type="button" onClick={cancelEditItem}>
              Cancel
            </button>
          </form>
        </div>
      )}

      {dispatchItemId && (
        <div className="dispatch-item-form">
          <h3>Dispatch Item</h3>
          <form>
            <label htmlFor="dispatch-quantity">Dispatch Quantity:</label>
            <input
              type="number"
              id="dispatch-quantity"
              name="dispatchQuantity"
              value={dispatchQuantity}
              onChange={handleDispatchQuantityChange}
            />

            <button type="button" onClick={dispatchItem}>
              Dispatch
            </button>
          </form>
        </div>
      )}

      <table className="additional-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Order Number</th>
            <th>Dispatch Quantity</th>
            <th>Sale Generated</th>
          </tr>
        </thead>
        <tbody>
          {sortedItems.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.orderNumber}</td>
              <td>{item.dispatchQuantity}</td>
              <td>{item.saleGenerated}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ItemTable;
