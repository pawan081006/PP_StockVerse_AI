import Navbar from "../components/Navbar";
import TradeForm from "../components/TradeForm";
import TradeHistory from "../components/TradeHistory";

function PaperTrading() {

  return (

    <div className="flex-1 bg-[#050816] min-h-screen text-white p-6">

      <Navbar />

      {/* Heading */}
      <div className="mt-6">

        <h1 className="text-4xl font-bold">
          📈 Paper Trading
        </h1>

        <p className="text-gray-400 mt-2">
          Buy and Sell Stocks with Virtual Money
        </p>

      </div>

      {/* Trade Form */}
      <div className="mt-8">
        <TradeForm />
      </div>

      {/* Trade History */}
      <div className="mt-8">
        <TradeHistory />
      </div>

    </div>

  );

}

export default PaperTrading;