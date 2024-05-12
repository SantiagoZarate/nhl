import { Route, Routes } from "react-router-dom";
import { AppLayout } from "./layouts/AppLayout";
import { HomePage, PlayerPage, TeamPage } from "@page";
import { NotFoundPage } from "./pages/NotFoundPage";

export default function App() {
  return (
    <Routes>
      <Route path="*" element={<NotFoundPage />} />
      <Route element={<AppLayout />}>
        <Route path="/" element={<HomePage />} />
        <Route path="/team/:teamName" element={<TeamPage />} />
        <Route path="/player/:playerId" element={<PlayerPage />} />
      </Route>
    </Routes>
  );
}
