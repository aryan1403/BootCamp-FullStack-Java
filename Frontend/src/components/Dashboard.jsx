import React, { useEffect, useRef } from "react";
import { useLocation } from "react-router-dom";
import Navbar from "./NavBar";

function Dashboard() {
  const location = useLocation();
  const priceChartRef = useRef(null);
  const quantityChartRef = useRef(null);

  useEffect(() => {
    if (location.pathname === "/dashboard") {
      // Generate sample data for the charts
      const priceData = [10, 30, 20, 60, 30, 50];
      const items = [
        { name: "Item A", quantity: 5, price: 10 },
        { name: "Item B", quantity: 8, price: 20 },
        { name: "Item C", quantity: 3, price: 15 },
        { name: "Item D", quantity: 12, price: 5 },
        { name: "Item E", quantity: 6, price: 18 },
      ];

      // Set up the chart dimensions
      const chartWidth = 400;
      const chartHeight = 400;

      // Set up the bar colors
      const barColor = "rgba(75, 192, 192, 0.6)";
      const borderColor = "rgba(75, 192, 192, 1)";

      // Get the canvas contexts for both charts
      const priceCtx = priceChartRef.current.getContext("2d");
      const quantityCtx = quantityChartRef.current.getContext("2d");

      // Calculate the width and height of each bar for the price chart
      const priceBarWidth = chartWidth / priceData.length;
      const maxPrice = Math.max(...priceData);
      const priceChartScale = chartHeight / maxPrice;

      // Draw the bars for the price chart
      priceData.forEach((value, index) => {
        const barHeight = value * priceChartScale;
        const x = index * priceBarWidth;
        const y = chartHeight - barHeight;

        priceCtx.fillStyle = barColor;
        priceCtx.fillRect(x, y, priceBarWidth, barHeight);

        priceCtx.strokeStyle = borderColor;
        priceCtx.strokeRect(x, y, priceBarWidth, barHeight);
      });

      // Sort items by quantity in descending order for the quantity chart
      const sortedItems = items.sort((a, b) => b.quantity - a.quantity);

      // Calculate the width of each bar for the quantity chart
      const maxQuantity = Math.max(...sortedItems.map((item) => item.quantity));
      const quantityBarWidth = (chartWidth / maxQuantity) * 0.8; // Reduce the width to fit the chart

      // Draw the bars and display item names for the quantity chart
      sortedItems.forEach((item, index) => {
        const barHeight = chartHeight / sortedItems.length;
        const x = 0;
        const y = index * barHeight;

        quantityCtx.fillStyle = barColor;
        quantityCtx.fillRect(x, y, item.quantity * quantityBarWidth, barHeight);

        quantityCtx.strokeStyle = borderColor;
        quantityCtx.strokeRect(
          x,
          y,
          item.quantity * quantityBarWidth,
          barHeight
        );

        // Display the item name and quantity
        quantityCtx.fillStyle = "black";
        quantityCtx.fillText(
          `${item.name} (${item.quantity})`,
          item.quantity * quantityBarWidth + 10,
          y + barHeight / 2
        );
      });
    }
  }, [location.pathname]);

  return (
    <div>
      <Navbar />
      <div>
        {location.pathname === "/dashboard" && (
          <div>
            <h1>Price Chart</h1>
            <canvas ref={priceChartRef} width={400} height={400}></canvas>
            <h1>Quantity Chart</h1>
            <canvas ref={quantityChartRef} width={400} height={400}></canvas>
          </div>
        )}
      </div>
    </div>
  );
}

export default Dashboard;
