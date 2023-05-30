import axios from "axios";

const URL = "http://localhost:8080/items";

export function addItemToDB(name, purpose, cost, warranty) {
  const data = {
    name: name,
    purpose: purpose,
    cost: cost,
    warranty: warranty,
  };
  axios
    .post(URL + "/addItems", data)
    .then((res) => {
      console.log(res.data);
      alert("Item added successfully!"); // Show success message
      return res.data;
    })
    .catch((error) => {
      console.error(error);
      alert("Failed to add item."); // Show error message
    });
}
