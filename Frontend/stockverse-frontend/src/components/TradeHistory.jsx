import { useEffect, useState } from "react";

function TradeHistory() {

  const [trades, setTrades] = useState([]);

  useEffect(() => {

    fetch("http://localhost:8080/api/papertrade/1")
      .then((response) => response.json())
      .then((data) => {

        console.log("Trades:", data);
        setTrades(data);

      })
      .catch((error) => {

        console.error(error);

      });

  }, []);

  return (

    <div className="bg-slate-900 border border-cyan-500/20 rounded-2xl p-6 mt-8">

      <h2 className="text-2xl font-bold text-cyan-400 mb-6">
        📜 Trade History
      </h2>

      {
        trades.length === 0 ? (

          <p className="text-gray-400">
            No trades available.
          </p>

        ) : (

          <table className="w-full">

            <thead>

              <tr className="border-b border-slate-700">

                <th className="text-left py-3">Stock ID</th>
                <th className="text-left py-3">Quantity</th>
                <th className="text-left py-3">Buy Price</th>
                <th className="text-left py-3">Type</th>

              </tr>

            </thead>

            <tbody>

              {trades.map((trade) => (

                <tr
                  key={trade.id}
                  className="border-b border-slate-800"
                >

                  <td className="py-3">{trade.stockId}</td>
                  <td>{trade.quantity}</td>
                  <td>₹{trade.buyPrice}</td>
                  <td className="text-green-400">
                    BUY
                  </td>

                </tr>

              ))}

            </tbody>

          </table>

        )

      }

    </div>

  );

}

export default TradeHistory;