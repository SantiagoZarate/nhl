import { Route, Routes } from "react-router-dom";
import { HomePage } from "./pages/home/HomePage";

export default function App() {
  return (
    <Routes>
      <Route index path="/" element={<HomePage />} />
    </Routes>
  );
}
