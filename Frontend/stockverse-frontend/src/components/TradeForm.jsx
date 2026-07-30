import { useState } from "react";

function TradeForm() {

  const [stockId, setStockId] = useState("");
  const [quantity, setQuantity] = useState("");
  const [buyPrice, setBuyPrice] = useState("");
  const [sellPrice, setSellPrice] = useState("");

  // BUY STOCK
  const handleBuy = async () => {

    const tradeData = {

      userId: 1,
      stockId: Number(stockId),
      quantity: Number(quantity),
      buyPrice: Number(buyPrice)

    };

    try {

      const response = await fetch(
        "http://localhost:8080/api/papertrade/buy",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(tradeData)
        }
      );

      if (!response.ok) {
        throw new Error("Buy Failed");
      }

      const data = await response.json();

      console.log("Buy Success:", data);

      alert("✅ Stock Purchased Successfully!");

      // Reset Form
      setStockId("");
      setQuantity("");
      setBuyPrice("");
      setSellPrice("");

    } catch (error) {

      console.error(error);

      alert("❌ Buy Failed!");

    }

  };

  return (

    <div className="bg-slate-900 border border-cyan-500/20 rounded-2xl p-6">

      <h2 className="text-2xl font-bold text-cyan-400 mb-6">
        Buy / Sell Stock
      </h2>

      <div className="grid grid-cols-2 gap-6">

        {/* Stock ID */}
        <div>

          <label className="block mb-2 text-gray-300">
            Stock ID
          </label>

          <input
            type="number"
            placeholder="Enter Stock ID"
            value={stockId}
            onChange={(e) => setStockId(e.target.value)}
            className="w-full p-3 rounded-lg bg-slate-800 border border-slate-600"
          />

        </div>

        {/* Quantity */}
        <div>

          <label className="block mb-2 text-gray-300">
            Quantity
          </label>

          <input
            type="number"
            placeholder="Enter Quantity"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            className="w-full p-3 rounded-lg bg-slate-800 border border-slate-600"
          />

        </div>

        {/* Buy Price */}
        <div>

          <label className="block mb-2 text-gray-300">
            Buy Price
          </label>

          <input
            type="number"
            placeholder="Enter Buy Price"
            value={buyPrice}
            onChange={(e) => setBuyPrice(e.target.value)}
            className="w-full p-3 rounded-lg bg-slate-800 border border-slate-600"
          />

        </div>

        {/* Sell Price */}
        <div>

          <label className="block mb-2 text-gray-300">
            Sell Price
          </label>

          <input
            type="number"
            placeholder="Enter Sell Price"
            value={sellPrice}
            onChange={(e) => setSellPrice(e.target.value)}
            className="w-full p-3 rounded-lg bg-slate-800 border border-slate-600"
          />

        </div>

      </div>

      {/* Buttons */}
      <div className="flex gap-4 mt-8">

        <button
          onClick={handleBuy}
          className="bg-green-500 hover:bg-green-600 px-6 py-3 rounded-xl font-bold"
        >
          BUY
        </button>

        <button
          className="bg-red-500 hover:bg-red-600 px-6 py-3 rounded-xl font-bold"
        >
          SELL
        </button>

      </div>

    </div>

  );

}

export default TradeForm;