import { useEffect, useState } from "react";

function Portfolio() {

  const [holdings, setHoldings] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {

    fetch("http://localhost:8080/api/papertrade/holdings/1")
      .then((response) => response.json())
      .then((data) => {
        console.log("Holdings Data:", data);
        setHoldings(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching holdings:", error);
        setLoading(false);
      });

  }, []);

  if (loading) {
    return (
      <div className="flex-1 bg-[#050816] min-h-screen text-white p-6">
        Loading Portfolio...
      </div>
    );
  }

  return (
    <div className="flex-1 bg-[#050816] min-h-screen text-white p-6">

      <h1 className="text-3xl font-bold mb-6">
        My Portfolio 📊
      </h1>

      {holdings.length === 0 ? (

        <div className="bg-slate-900 p-6 rounded-2xl">
          <p className="text-gray-400">
            You don't have any holdings yet.
          </p>
        </div>

      ) : (

        <div className="bg-slate-900 rounded-2xl overflow-hidden">

          <div className="grid grid-cols-2 bg-slate-800 p-4 font-bold">
            <span>Stock ID</span>
            <span>Quantity</span>
          </div>

          {holdings.map((holding) => (

            <div
              key={holding.stockId}
              className="grid grid-cols-2 p-4 border-t border-slate-700"
            >

              <span>
                Stock {holding.stockId}
              </span>

              <span className="text-green-400 font-semibold">
                {holding.quantity}
              </span>

            </div>

          ))}

        </div>

      )}

    </div>
  );
}

export default Portfolio;