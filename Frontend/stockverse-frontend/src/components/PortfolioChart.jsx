import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

const data = [
 { day: "Mon", value: 950000 },
  { day: "Tue", value: 970000 },
  { day: "Wed", value: 985000 },
  { day: "Thu", value: 992000 },
  { day: "Fri", value: 1000000 },
  { day: "Sat", value: 1010000 },
  { day: "Sun", value: 1020000 },
];

function PortfolioChart() {
  return (
    <div className="bg-slate-900 border border-cyan-500/20 p-6 rounded-2xl mt-6">
      <h2 className="text-cyan-400 text-xl font-bold mb-4">
        📊 Portfolio Growth
      </h2>

      <ResponsiveContainer width="100%" height={300}>
        <LineChart data={data}>
          <XAxis dataKey="day" />
          <YAxis />
          <Tooltip />
          <Line
            type="monotone"
            dataKey="value"
            stroke="#00ffff"
            strokeWidth={3}
          />
        </LineChart>
      </ResponsiveContainer>
    </div>
  );
}

export default PortfolioChart;