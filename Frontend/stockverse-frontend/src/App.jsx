import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Sidebar from "./components/Sidebar";

import Dashboard from "./pages/Dashboard";
import Portfolio from "./pages/Portfolio";
import PaperTrading from "./pages/PaperTrading";

function App() {

  return (

    <BrowserRouter>

      <div className="flex">

        <Sidebar />

        <Routes>

          <Route
            path="/"
            element={<Navigate to="/dashboard" replace />}
          />

          <Route
            path="/dashboard"
            element={<Dashboard />}
          />

          <Route
            path="/portfolio"
            element={<Portfolio />}
          />

          <Route
            path="/papertrading"
            element={<PaperTrading />}
          />

          {/* Default Route */}
          <Route
            path="*"
            element={<Navigate to="/dashboard" replace />}
          />

        </Routes>

      </div>

    </BrowserRouter>

  );

}

export default App;