import { Route, Routes } from "react-router-dom";
import { AppLayout } from "./layouts/AppLayout";
import { NotFoundPage } from "./pages/NotFoundPage";
import { PlayerPageLayout } from "./layouts/PlayerPageLayout";
import { TeamsPage } from "./pages/teams/TeamsPage";
import {
  HomePage,
  PlayerPage,
  PlayerSkillsPage,
  PlayersPage,
  TeamPage,
  LoginPage,
  RegisterPage
} from "@page";
import { AuthLayout } from "./layouts/AuthLayout";

export default function App() {
  return (
    <Routes>
      <Route path="*" element={<NotFoundPage />} />
      <Route element={<AppLayout />}>
        <Route path="/" element={<HomePage />} />
        <Route path="/teams" element={<TeamsPage />} />
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
        <Route path="/auth" element={<AuthLayout />}>
          <Route path="login" element={<LoginPage />} />
          <Route path="register" element={<RegisterPage />} />
        </Route>
      </Route>
    </Routes>
  );
}
