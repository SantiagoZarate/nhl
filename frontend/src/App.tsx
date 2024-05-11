import { Route, Routes } from "react-router-dom";
import { AppLayout } from "./layouts/AppLayout";
import { HomePage } from "@page";

export default function App() {
  return (
    <Routes>
      <Route element={<AppLayout />}>
        <Route index path="/" element={<HomePage />} />
        <Route index path="/:team" element={<HomePage />} />
        <Route index path="/:player" element={<HomePage />} />
      </Route>
    </Routes>
  );
}
