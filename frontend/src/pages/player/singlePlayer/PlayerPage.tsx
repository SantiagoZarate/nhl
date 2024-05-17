import { usePlayer } from "@/hooks/usePlayer";
import { Navigate, useParams } from "react-router-dom";
import { PlayerInfo } from "./information/PlayerInfo";
import { PlayerPicture } from "./information/PlayerPicture";
import { PlayerRecentGames } from "./recentGames/PlayerRecentGames";
import { PlayerRecentSkills } from "./skills/PlayerRecentSkills";
import { InfoSkeleton } from "./loading/InfoSkeleton";
import { RecentGamesSkeleton } from "./loading/RecentGamesSkeleton";
import { SkillsChart } from "./skills/SkillsChart";
import { RecentGamesList } from "./recentGames/RecentGamesList";

export function PlayerPage() {
  const { playerId } = useParams();
  const { isLoading, player, error, statsIsLoading, stats } = usePlayer(
    playerId!
  );

  if (error) {
    return <Navigate to={"/404"} />;
  }

  return (
    <div className="flex flex-col gap-8">
      {isLoading ? (
        <InfoSkeleton />
      ) : (
        <section className="flex gap-6">
          <PlayerPicture imageURL={player?.image_url} />
          <PlayerInfo
            name={player?.name}
            nationality={player?.nationality}
            skillLevel={player?.skill_level}
            teamName={player?.team.name}
          />
        </section>
      )}

      <section className="grid gap-8 grid-cols-1 sm:grid-cols-2">
        <PlayerRecentGames>
          {statsIsLoading ? (
            <RecentGamesSkeleton />
          ) : (
            <RecentGamesList stats={stats} teamName={player?.team.name} />
          )}
        </PlayerRecentGames>

        <PlayerRecentSkills>
          {isLoading ? (
            <div className="bg-secondary rounded-lg h-full w-full flex items-center justify-center">
              there is no record about this player skills...
            </div>
          ) : (
            <SkillsChart skills={player?.skills!} />
          )}
        </PlayerRecentSkills>
      </section>
    </div>
  );
}
