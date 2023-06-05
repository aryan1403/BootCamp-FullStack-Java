import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "./Navbar";

function Stock({ setShouldUpdateItems, setAlertCount }) {
  const [items, setItems] = useState([]);
  const [addQuantity, setAddQuantity] = useState(0);
  const [selectedItem, setSelectedItem] = useState(null);
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = async () => {
    try {
      const response = await axios.get("http://localhost:8080/items");
      setItems(response.data);
      setAlertCount(
        response.data.filter((item) => item.quantity < 1000).length
      );
    } catch (error) {
      console.log(error);
    }
  };

  const handleItemUpdated = () => {
    fetchItems();
    setShouldUpdateItems(true);
  };

  const handleAddQuantityChange = (event) => {
    setAddQuantity(Number(event.target.value));
  };

  const handleAddQuantitySubmit = async (event) => {
    event.preventDefault();
    try {
      const updatedItem = {
        ...selectedItem,
        quantity: selectedItem.quantity + addQuantity,
      };
      await axios.put(
        `http://localhost:8080/items/${selectedItem.id}`,
        updatedItem
      );
      setAddQuantity(0);
      fetchItems();
      setShowModal(false);
    } catch (error) {
      console.log(error);
    }
  };

  const openModal = (item) => {
    setSelectedItem(item);
    setAddQuantity(""); // Reset the addQuantity when opening the modal
    setShowModal(true);
  };

  const closeModal = () => {
    setShowModal(false);
  };

  const filteredItems = items.filter((item) => item.quantity < 1000);
  const alertCount = filteredItems.length;

  return (
    <>
      <div>
        <h2>Stock</h2>
        {filteredItems.map((item) => (
          <div key={item.id}>
            <p
              className="alert"
              style={{ backgroundColor: "red", color: "white" }}
            >
              Only {item.quantity} of {item.name} are left. Order More Soon !!
              <button onClick={() => openModal(item)}>Order Now</button>
            </p>
          </div>
        ))}
      </div>

      <div
        className={`modal fade ${showModal ? "show" : ""}`}
        style={{ display: showModal ? "block" : "none" }}
        tabIndex="-1"
        role="dialog"
        aria-hidden={!showModal}
      >
        <div className="modal-dialog" role="document">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Add Quantity</h5>
              <button
                type="button"
                className="close"
                data-dismiss="modal"
                aria-label="Close"
                onClick={closeModal}
              >
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div className="modal-body">
              <form onSubmit={handleAddQuantitySubmit}>
                <div className="form-group">
                  <label>Quantity:</label>
                  <input
                    type="number"
                    className="form-control"
                    value={addQuantity}
                    onChange={handleAddQuantityChange}
                  />
                </div>
                <button type="submit" className="btn btn-primary">
                  Add
                </button>
                <button
                  type="button"
                  className="btn btn-secondary"
                  data-dismiss="modal"
                  onClick={closeModal}
                >
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
      {showModal && (
        <div
          className="modal-backdrop fade show"
          style={{ zIndex: "1050" }}
        ></div>
      )}
    </>
  );
}

export default Stock;
