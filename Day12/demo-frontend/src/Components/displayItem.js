import { useEffect, useState } from "react";
import { getAllItems } from "../Service/service";
import Item from "./item";
import "./displayItem.css";

export default function DisplayItem() {
  const [items, setitems] = useState([]);

  useEffect(() => {
    getAllItems().then((data) => {
      setitems(data);
    });
  }, []);

  return (
    <>
      {
        <div className="row">
          {items.map((item) => {
            return <Item itemName={item.name} itemDesc={item.role}></Item>;
          })}
        </div>
      }
    </>
  );
}
