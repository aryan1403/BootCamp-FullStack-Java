import Item from "../resources/Item.webp";
import "./item.css";
export default function item(props) {
  return (
    <>
      <div className="card">
        <img src={Item} className="card-img-top" alt="..." />
        <div className="card-body">
          <h5 className="card-title">{props.itemName}</h5>
          <p className="card-text">{props.itemDesc}</p>
          <a href="/" className="btn btn-success">
            Edit
          </a>
          <a href="/" className="btn btn-danger">
            Delete
          </a>
        </div>
      </div>
    </>
  );
}
