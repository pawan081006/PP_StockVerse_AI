import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div className="w-64 bg-slate-800 min-h-screen p-5 border-r border-slate-700">

      <h1 className="text-2xl font-bold text-green-400">
        PP_StockVerse AI
      </h1>

      <ul className="mt-10 space-y-5">

        <li>
          <Link
            to="/dashboard"
            className="hover:text-green-400 cursor-pointer"
          >
            🏠 Dashboard
          </Link>
        </li>

        <li>
          <Link
            to="/portfolio"
            className="hover:text-green-400 cursor-pointer"
          >
            💼 Portfolio
          </Link>
        </li>

        <li>
          <Link
            to="/watchlist"
            className="hover:text-green-400 cursor-pointer"
          >
            ⭐ Watchlist
          </Link>
        </li>

        <li>
          <Link
            to="/papertrading"
            className="hover:text-green-400 cursor-pointer"
          >
            📈 Paper Trading
          </Link>
        </li>

        <li>
          <Link
            to="/aimentor"
            className="hover:text-green-400 cursor-pointer"
          >
            🤖 AI Mentor
          </Link>
        </li>

        <li>
          <Link
            to="/news"
            className="hover:text-green-400 cursor-pointer"
          >
            📰 News
          </Link>
        </li>

        <li>
          <Link
            to="/settings"
            className="hover:text-green-400 cursor-pointer"
          >
            ⚙ Settings
          </Link>
        </li>

      </ul>

    </div>
  );
}

export default Sidebar;