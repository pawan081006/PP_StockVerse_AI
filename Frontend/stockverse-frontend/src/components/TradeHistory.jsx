import { useEffect, useState } from "react";

function TradeHistory({ refresh }) {

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

  }, [refresh]);

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

                <th className="text-left py-3">
                  Stock ID
                </th>

                <th className="text-left py-3">
                  Quantity
                </th>

                <th className="text-left py-3">
                  Price
                </th>

                <th className="text-left py-3">
                  Type
                </th>

                <th className="text-left py-3">
                  Time
                </th>

              </tr>

            </thead>

            <tbody>

              {

                trades.map((trade) => (

                  <tr
                    key={trade.id}
                    className="border-b border-slate-800"
                  >

                    <td className="py-3">
                      {trade.stockId}
                    </td>

                    <td>
                      {trade.quantity}
                    </td>

                    <td>

                      ₹

                      {

                        trade.tradeType === "BUY"

                          ? trade.buyPrice

                          : trade.sellPrice

                      }

                    </td>

                    <td
                      className={
                        trade.tradeType === "BUY"
                          ? "text-green-400 font-bold"
                          : "text-red-400 font-bold"
                      }
                    >

                      {trade.tradeType}

                    </td>

                    <td className="text-gray-400 text-sm">

                      {

                        new Date(trade.tradeTime)
                          .toLocaleString()

                      }

                    </td>

                  </tr>

                ))

              }

            </tbody>

          </table>

        )

      }

    </div>

  );

}

export default TradeHistory;