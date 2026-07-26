import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Sidebar from "./components/Sidebar";
import Dashboard from "./pages/Dashboard";
import Portfolio from "./pages/Portfolio";

function App() {
  return (
    <BrowserRouter>

      <div className="flex">

        <Sidebar />

        <Routes>

          <Route
            path="/dashboard"
            element={<Dashboard />}
          />

          <Route
            path="/portfolio"
            element={<Portfolio />}
          />

          {/* Default page */}
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