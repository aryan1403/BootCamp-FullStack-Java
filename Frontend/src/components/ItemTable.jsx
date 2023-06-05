import React, { useState, useEffect } from "react";
import axios from "axios";

function ItemTable() {
  const [items, setItems] = useState([]);
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

  const handleDeleteItem = async (itemId) => {
    try {
      await axios.delete(`http://localhost:8080/items/${itemId}`);
      fetchItems(); // Refresh the item list after deletion
    } catch (error) {
      console.log(error);
    }
  };

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
      fetchItems(); // Refresh the item list after update
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
      fetchItems(); // Refresh the item list after dispatch
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
      <table className="table table-striped item-table">
        <thead>
          <tr>
            <th className="bg-dark text-light">ID</th>
            <th className="bg-dark text-light">Name</th>
            <th className="bg-dark text-light">Type</th>
            <th
              onClick={() => handleSortColumn("price")}
              className={`${
                sortColumn.column === "price" ? sortColumn.order : ""
              } bg-dark text-light`}
            >
              Price {getSortIndicator("price")}
            </th>
            <th
              onClick={() => handleSortColumn("quantity")}
              className={`${
                sortColumn.column === "quantity" ? sortColumn.order : ""
              } bg-dark text-light`}
            >
              Quantity {getSortIndicator("quantity")}
            </th>
            <th className="bg-dark text-light">Action</th>
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
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={() => handleDeleteItem(item.id)}
                >
                  Delete
                </button>
                {editItemId !== item.id && (
                  <button
                    type="button"
                    className="btn btn-primary"
                    onClick={() => handleEditItem(item.id)}
                  >
                    Edit
                  </button>
                )}
                <button
                  type="button"
                  className="btn btn-success"
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
            <div>
              <label>ID:</label>
              <input
                type="text"
                name="id"
                value={editItemData.id}
                onChange={handleEditItemChange}
              />
            </div>
            <div>
              <h2>Dispatch Table</h2>
              <label>Name:</label>
              <input
                type="text"
                name="name"
                value={editItemData.name}
                onChange={handleEditItemChange}
              />
            </div>
            <div>
              <label>Price:</label>
              <input
                type="text"
                name="price"
                value={editItemData.price}
                onChange={handleEditItemChange}
              />
            </div>
            <div>
              <label>Type:</label>
              <input
                type="text"
                name="type"
                value={editItemData.type}
                onChange={handleEditItemChange}
              />
            </div>
            <div>
              <label>Quantity:</label>
              <input
                type="text"
                name="quantity"
                value={editItemData.quantity}
                onChange={handleEditItemChange}
              />
            </div>
          </form>
          <button type="button" onClick={saveEditItem}>
            Save
          </button>
          <button type="button" onClick={cancelEditItem}>
            Cancel
          </button>
        </div>
      )}

      {dispatchItemId && (
        <div className="dispatch-item-form">
          <h3>Dispatch Item</h3>
          <form>
            <div>
              <label>Dispatch Quantity:</label>
              <input
                type="text"
                name="dispatchQuantity"
                value={dispatchQuantity}
                onChange={handleDispatchQuantityChange}
              />
            </div>
          </form>
          <button type="button" onClick={dispatchItem}>
            Dispatch
          </button>
        </div>
      )}

      <table className="table additional-table bg-dark">
        <thead>
          <tr className="bg-dark">
            <th className="bg-dark text-light">ID</th>
            <th className="bg-dark text-light">Name</th>
            <th className="bg-dark text-light">Order Number</th>
            <th className="bg-dark text-light">Dispatch Quantity</th>
            <th className="bg-dark text-light">Sale Generated</th>
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
