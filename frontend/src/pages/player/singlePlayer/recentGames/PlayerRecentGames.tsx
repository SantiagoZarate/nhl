import { getWinnerTeam } from "@/helpers/getWinnerTeam";
import { usePlayer } from "@/hooks/usePlayer";
import { useParams } from "react-router-dom";
import { RecentGame } from "./RecentGame";
import { HockeyArenaIcon } from "@/components/icons";
import { Subheader } from "@/components/ui/Subheader";

interface Props {
  name: string;
  teamName: string;
}

export function PlayerRecentGames({ name, teamName }: Partial<Props>) {
  const { playerId } = useParams();
  const { stats } = usePlayer(playerId!);

  return (
    <section className="flex flex-col gap-4">
      <Subheader icon={<HockeyArenaIcon />}>Most recent {name} games</Subheader>
      <ul className="flex flex-col gap-4">
        {stats.map((stat) => {
          return (
            <RecentGame
              key={stat.id}
              stats={stat}
              winner={getWinnerTeam(stat.game) === teamName}
            />
          );
        })}
      </ul>
    </section>
  );
}
