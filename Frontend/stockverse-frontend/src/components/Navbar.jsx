function Navbar() {
  return (
    <div className="bg-slate-800 p-4 rounded-xl flex justify-between items-center">
      <h2 className="text-xl font-bold">Dashboard</h2>

      <div className="flex gap-4 items-center">
        <span>🔔</span>
        <span>👤 Pawan</span>
      </div>
    </div>
  );
}

export default Navbar;