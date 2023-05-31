import React from "react";
import { useLocation } from "react-router-dom";

function Stock() {
  const location = useLocation();

  const stockNews = [
    {
      id: 1,
      title:
        "Tech Giant's New Product Launch Receives Positive Market Response",
      description:
        "Tech Giant unveils a revolutionary new product, causing its stock price to surge.",
      link: "https://example.com/news/1",
    },
    {
      id: 2,
      title: "Energy Company Expands Operations in Overseas Market",
      description:
        "Energy Company announces plans to expand its operations in a lucrative overseas market.",
      link: "https://example.com/news/2",
    },
    {
      id: 3,
      title: "Retail Chain Reports Impressive Sales Growth in Q2",
      description:
        "Retail Chain reveals substantial sales growth in the second quarter, exceeding market expectations.",
      link: "https://example.com/news/3",
    },
    {
      id: 4,
      title: "Automaker Unveils Next-Generation Electric Vehicle",
      description:
        "Automaker introduces an advanced electric vehicle with longer range and enhanced features.",
      link: "https://example.com/news/4",
    },
    {
      id: 5,
      title: "Banking Institution Launches Innovative Digital Banking Solution",
      description:
        "Banking Institution introduces a cutting-edge digital banking solution, aiming to enhance customer experience.",
      link: "https://example.com/news/5",
    },
    {
      id: 6,
      title: "Pharmaceutical Company Receives FDA Approval for New Drug",
      description:
        "Pharmaceutical Company receives regulatory approval for a groundbreaking drug to treat a common ailment.",
      link: "https://example.com/news/6",
    },
    {
      id: 7,
      title: "E-commerce Platform Surpasses Billion-Dollar Sales Milestone",
      description:
        "E-commerce Platform celebrates surpassing one billion dollars in total sales since its inception.",
      link: "https://example.com/news/7",
    },
    {
      id: 8,
      title:
        "Airline Carrier Expands Route Network to Include New Destinations",
      description:
        "Airline Carrier announces the addition of several new destinations to its route network, providing more travel options.",
      link: "https://example.com/news/8",
    },
    {
      id: 9,
      title: "Software Company Releases Major Update to Popular Application",
      description:
        "Software Company rolls out a significant update to its widely used application, introducing exciting new features.",
      link: "https://example.com/news/9",
    },
    {
      id: 10,
      title: "Food and Beverage Company Launches Healthy Product Line",
      description:
        "Food and Beverage Company introduces a new range of healthy products to cater to health-conscious consumers.",
      link: "https://example.com/news/10",
    },
  ];

  return (
    <div>
      {location.pathname === "/stock" && (
        <div>
          {stockNews.map((news) => (
            <div key={news.id}>
              <h2>
                <a href={news.link} target="_blank" rel="noopener noreferrer">
                  {news.title}
                </a>
              </h2>
              <p>{news.description}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default Stock;
