import { Route, Routes } from "react-router-dom";
import { AppLayout } from "./layouts/AppLayout";
import {
  HomePage,
  PlayerPage,
  PlayerSkillsPage,
  PlayersPage,
  TeamPage,
} from "@page";
import { NotFoundPage } from "./pages/NotFoundPage";
import { PlayerPageLayout } from "./layouts/PlayerPageLayout";

export default function App() {
  return (
    <Routes>
      <Route path="*" element={<NotFoundPage />} />
      <Route element={<AppLayout />}>
        <Route path="/" element={<HomePage />} />
        <Route path="/team/:teamName" element={<TeamPage />} />
        <Route path="/players" element={<PlayersPage />} />
        <Route path="/players/:playerId" element={<PlayerPageLayout />}>
          <Route path="/players/:playerId/" element={<PlayerPage />} />
          <Route
            path="/players/:playerId/skills"
            element={<PlayerSkillsPage />}
          />
          <Route path="/players/:playerId/games" element={<PlayerPage />} />
        </Route>
      </Route>
    </Routes>
  );
}
