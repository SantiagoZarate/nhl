import { usePlayer } from "@/hooks/usePlayer";
import { Navigate, useParams } from "react-router-dom";
import { PlayerInfo } from "./PlayerInfo";
import { PlayerNavBar } from "./PlayerNavBar";
import { PlayerPicture } from "./PlayerPicture";
import { PlayerRecentGames } from "./PlayerRecentGames";

export function PlayerPage() {
  const { playerId } = useParams();
  const { isLoading, player, error } = usePlayer(playerId!);

  if (error) {
    return <Navigate to={"/404"} />;
  }

  return isLoading ? (
    <div className="flex items-center justify-center">Loading player...</div>
  ) : (
    <div className="flex flex-col gap-8">
      <PlayerNavBar />
      <section className="flex gap-6">
        <PlayerPicture imageURL={player?.image_url} />
        <PlayerInfo
          name={player?.name}
          nationality={player?.nationality}
          skillLevel={player?.skill_level}
          teamName={player?.team.name}
        />
      </section>
      <PlayerRecentGames name={player?.name} teamName={player?.team.name} />
    </div>
  );
}
