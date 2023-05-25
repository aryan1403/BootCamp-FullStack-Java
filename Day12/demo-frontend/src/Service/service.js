import axios from "axios";

const URL = "http://localhost:8080";

export async function addItemToDB(name, purpose, cost, warranty) {
  const data = {
    name: name,
    purpose: purpose,
    cost: cost,
    warranty: warranty,
  };
  return await axios.post(URL + "/addItem", data).then((res) => {
    console.log(res.data);
    alert(res.data.msg);
    return res.data;
  });
}

export async function getAllItems() {
  return await axios.get(URL + "/getItems").then((res) => {
    const items = res.data.data;
    return items;
  });
}

export async function deleteItemFromDB(itemId) {
  return await axios.delete(URL + `/deleteItem/${itemId}`).then((res) => {
    console.log(res.data);
    alert(res.data.msg);
    return res.data;
  });
}

export async function updateItemInDB(item) {
  return await axios.post(URL + "/updateItem", item).then((res) => {
    console.log(res.data);
    alert(res.data.msg);
    return res.data;
  });
}
