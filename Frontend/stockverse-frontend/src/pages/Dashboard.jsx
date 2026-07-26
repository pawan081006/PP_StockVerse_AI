


import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import PortfolioChart from "../components/PortfolioChart";

function Dashboard() {

  const [portfolio, setPortfolio] = useState(null);

  useEffect(() => {

    fetch("http://localhost:8080/api/papertrade/summary/1")
      .then((response) => response.json())
      .then((data) => {
        console.log("Backend Data:", data);
        setPortfolio(data);
      })
      .catch((error) => {
        console.error("Error fetching portfolio:", error);
      });

  }, []);

  if (!portfolio) {
    return (
      <div className="flex-1 bg-[#050816] min-h-screen text-white p-6">
        Loading Portfolio...
      </div>
    );
  }

  return (
    <div className="flex-1 p-6 bg-[#050816] min-h-screen text-white">

      <Navbar />

      {/* Hero Section */}
      <div className="mt-6 bg-gradient-to-r from-cyan-500/20 to-green-500/20 border border-cyan-500/30 p-6 rounded-3xl">

        <h1 className="text-4xl font-bold">
          Welcome Back, Pawan 🚀
        </h1>

        <p className="text-gray-400 mt-2 text-lg">
          AI Market Intelligence Center
        </p>

      </div>

      {/* Portfolio Cards */}
      <div className="grid grid-cols-3 gap-5 mt-6">

        {/* Portfolio Value */}
        <div className="bg-slate-900 border border-green-500/30 p-5 rounded-2xl">

          <h3 className="text-gray-400">
            Portfolio Value
          </h3>

          <p className="text-4xl font-bold text-green-400 mt-2">
            ₹{portfolio.portfolioValue.toLocaleString("en-IN")}
          </p>

          <p className="text-green-500 mt-2">
            Profit/Loss: ₹{portfolio.profitLoss.toLocaleString("en-IN")}
          </p>

        </div>

        {/* Wallet Balance */}
        <div className="bg-slate-900 border border-cyan-500/30 p-5 rounded-2xl">

          <h3 className="text-gray-400">
            Wallet Balance
          </h3>

          <p className="text-4xl font-bold text-cyan-400 mt-2">
            ₹{portfolio.walletBalance.toLocaleString("en-IN")}
          </p>

        </div>

        {/* Holdings */}
        <div className="bg-slate-900 border border-purple-500/30 p-5 rounded-2xl">

          <h3 className="text-gray-400">
            Total Holdings
          </h3>

          <p className="text-4xl font-bold text-purple-400 mt-2">
            {portfolio.totalHoldings}
          </p>

          <p className="text-gray-400 mt-2">
            Total Trades: {portfolio.totalTrades}
          </p>

        </div>

      </div>

      {/* XP System */}
      <div className="mt-6 bg-slate-900 border border-yellow-500/20 p-6 rounded-2xl">

        <div className="flex justify-between">

          <h2 className="text-xl font-bold text-yellow-400">
            ⭐ Investor Level
          </h2>

          <span className="text-green-400 font-bold">
            Level 5
          </span>

        </div>

        <div className="w-full bg-slate-700 rounded-full h-4 mt-4">

          <div
            className="bg-gradient-to-r from-green-400 to-cyan-400 h-4 rounded-full"
            style={{ width: "65%" }}
          ></div>

        </div>

        <p className="mt-3 text-gray-400">
          650 XP / 1000 XP
        </p>

      </div>

      {/* AI Mentor */}
      <div className="mt-6 bg-slate-900 border border-cyan-500/20 p-6 rounded-2xl">

        <h2 className="text-2xl font-bold text-cyan-400">
          🤖 Athena AI
        </h2>

        <p className="mt-4 text-gray-300">
          Market sentiment is Bullish today.
        </p>

        <p className="text-green-400 mt-2">
          Suggested Sector: Information Technology
        </p>

      </div>

      {/* Watchlist */}
      <div className="mt-6 bg-slate-900 border border-blue-500/20 p-6 rounded-2xl">

        <h2 className="text-blue-400 text-xl font-bold">
          📈 Watchlist
        </h2>

        <div className="mt-4 space-y-4">

          <div className="flex justify-between">
            <span>TCS</span>
            <span className="text-green-400">+2.4%</span>
          </div>

          <div className="flex justify-between">
            <span>INFY</span>
            <span className="text-green-400">+1.8%</span>
          </div>

          <div className="flex justify-between">
            <span>RELIANCE</span>
            <span className="text-red-400">-0.7%</span>
          </div>

          <div className="flex justify-between">
            <span>HDFC BANK</span>
            <span className="text-green-400">+1.2%</span>
          </div>

        </div>

      </div>

      {/* Portfolio Chart */}
      <PortfolioChart />

    </div>
  );
}

export default Dashboard;