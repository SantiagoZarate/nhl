import { getWinnerTeam } from "@/helpers/getWinnerTeam";
import { PlayerStats } from "@/types/playerStats";
import { RecentGame } from "./RecentGame";

interface Propss {
  stats: PlayerStats[];
  teamName: string;
}

export function RecentGamesList({ stats, teamName }: Propss) {
  return (
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
  );
}
