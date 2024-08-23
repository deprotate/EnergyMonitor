//import logo from './logo.svg';
import SolarPanel1 from './SolarPanel1.jpg';
import './App.css';

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

function App() {
  const [numberCounts, setNumberCounts] = useState({});

  useEffect(() => {
    fetchNumberCounts();
  }, []);

  const fetchNumberCounts = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/energy/v1.0/report');
      setNumberCounts(response.data);
    } catch (error) {
      console.error('Error fetching number counts:', error);
    }
  };


  const chartData = {
    labels: ["Электороэнергия"],
    datasets: [
      {
        label: "Энергии потрачено, Вт",
        data: Array.from({ length: 1 }, (_, i) => numberCounts[i + 1] || 0),
        backgroundColor: 'rgba(255, 46, 102, 0.8)'

      },
      {
        label: "Энергии получено, Вт",
        data: Array.from({ length: 1 }, (_, i) => numberCounts[i + 2] || 0),
        backgroundColor: 'rgba(60, 255, 23, 0.88)'

      },
      {
        label: "Энергии взято из сети, Вт",
        data: Array.from({ length: 1 }, (_, i) => numberCounts[i + 3] || 0),
        backgroundColor: 'rgba(228, 23, 255, 0.88)'

      },
      {
        label: "Энергии оттдано в сеть, Вт",
        data: Array.from({ length: 1 }, (_, i) => numberCounts[i + 4] || 0),
        backgroundColor: 'rgba(109, 238, 129, 0.88)'
      }

    ],
  };

  return (
    <div className="App">
      <h1>Добро пожаловать!</h1>
      <div className="Bar" style={{ width: '500px', height: '500px', margin: '20px auto' }}>
        <Bar data={chartData} />
      </div>
      <div>
        <img style={{ width: '500px', height: '500px', margin: '20px auto' }} src={SolarPanel1} alt="SolarPanel1" />
      </div>
    </div>
  );
}

export default App;
