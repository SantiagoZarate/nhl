import { usePlayer } from "@/hooks/usePlayer";
import { RecentGamesSkeleton } from "../loading/RecentGamesSkeleton";
import { PlayerRecentGames } from "./PlayerRecentGames";
import { RecentGamesList } from "./RecentGamesList";
import { useParams } from "react-router-dom";

export function RecentGamesHandler() {
  const { playerId } = useParams();
  const { statsIsLoading, stats, player } = usePlayer(playerId!);

  return (
    <PlayerRecentGames>
      {statsIsLoading ? (
        <RecentGamesSkeleton />
      ) : (
        <RecentGamesList stats={stats!} teamName={player?.team.name} />
      )}
    </PlayerRecentGames>
  );
}
