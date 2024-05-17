import { usePlayer } from "@/hooks/usePlayer";
import { Navigate, useParams } from "react-router-dom";
import { PlayerInfo } from "./PlayerInfo";
import { PlayerNavBar } from "./PlayerNavBar";
import { PlayerPicture } from "./PlayerPicture";
import { PlayerRecentGames } from "./PlayerRecentGames";
import { PlayerRecentSkills } from "./PlayerRecentSkills";

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
      <section className="grid gap-8 grid-cols-1 sm:grid-cols-2">
        <PlayerRecentGames name={player?.name} teamName={player?.team.name} />
        {player?.skills ? (
          <PlayerRecentSkills skills={player?.skills!} />
        ) : (
          <div className="w-full flex flex-col gap-4 justify-center h-48">
            <article className="">
              <h3 className="text-sm font-bold uppercase">Recent skills</h3>
            </article>
            <div className="bg-secondary rounded-lg h-full w-full flex items-center justify-center">
              there is no record about this player skills...
            </div>
          </div>
        )}
      </section>
    </div>
  );
}
