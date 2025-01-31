import React, { useEffect, useState } from 'react';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import { Line } from 'react-chartjs-2';
import axios from 'axios';
import { Card, Row, Col } from 'react-bootstrap';

// Register Chart.js components
ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);

const Dashboard = () => {
  const [inventoryData, setInventoryData] = useState([]);
  const [predictions, setPredictions] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/api/inventory')
      .then(response => {
        setInventoryData(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error(error);
        setError("Failed to load inventory data");
        setLoading(false);
      });

    axios.get('http://localhost:8080/api/predictions')
      .then(response => {
        setPredictions(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error(error);
        setError("Failed to load predictions");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  const chartData = {
    labels: inventoryData.map(item => item.product.name),
    datasets: [
      {
        label: 'Current Stock',
        data: inventoryData.map(item => item.currentStock),
        borderColor: 'rgb(75, 192, 192)',
      },
      {
        label: 'Predicted Demand',
        data: predictions,
        borderColor: 'rgb(255, 99, 132)',
      },
    ],
  };

  return (
    <div>
      <h2>Inventory Dashboard</h2>
      <Row>
        <Col md={8}>
          <Card>
            <Card.Body>
              <Card.Title>Inventory Overview</Card.Title>
              <Line data={chartData} />
            </Card.Body>
          </Card>
        </Col>
        <Col md={4}>
          <Card>
            <Card.Body>
              <Card.Title>Quick Actions</Card.Title>
              <ul className="list-group">
                <li className="list-group-item">Add Product</li>
                <li className="list-group-item">View Categories</li>
                <li className="list-group-item">Generate Report</li>
              </ul>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </div>
  );
};

export default Dashboard;