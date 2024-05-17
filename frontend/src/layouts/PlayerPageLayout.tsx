import { PlayerNavBar } from "@/pages/player/singlePlayer/PlayerNavBar";
import { Outlet } from "react-router-dom";

export function PlayerPageLayout() {
  return (
    <div className="flex flex-col gap-8">
      <PlayerNavBar />
      <Outlet />
    </div>
  );
}
