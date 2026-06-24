function Sidebar() {
  return (
    <div className="w-64 bg-slate-800 min-h-screen p-5 border-r border-slate-700">
      <h1 className="text-2xl font-bold text-green-400">
        PP_StockVerse AI
      </h1>

      <ul className="mt-10 space-y-5">
        <li className="hover:text-green-400 cursor-pointer">🏠 Dashboard</li>
        <li className="hover:text-green-400 cursor-pointer">💼 Portfolio</li>
        <li className="hover:text-green-400 cursor-pointer">⭐ Watchlist</li>
        <li className="hover:text-green-400 cursor-pointer">📈 Paper Trading</li>
        <li className="hover:text-green-400 cursor-pointer">🤖 AI Mentor</li>
        <li className="hover:text-green-400 cursor-pointer">📰 News</li>
        <li className="hover:text-green-400 cursor-pointer">⚙ Settings</li>
      </ul>
    </div>
  );
}

export default Sidebar;