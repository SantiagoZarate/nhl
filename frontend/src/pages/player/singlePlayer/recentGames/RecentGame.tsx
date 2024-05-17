import { MicroClockIcon, ScoreIcon } from "@/components/icons";
import { PlayerStats } from "@/types/playerStats";
import { PlayerGameInfo } from "./PlayerGameInfo";
import { TeamScore } from "./TeamScore";

interface Props {
  winner: boolean;
  stats: PlayerStats;
}

export function RecentGame({ winner, stats }: Props) {
  return (
    <li
      className={`relative z-0 shadow-sm overflow-hidden flex justify-between border border-border p-2 rounded-lg before:absolute before:inset-0 before:bg-gradient-to-r 
              before:from-transparent before:from-45% before:-z-10 ${
                winner ? "before:to-green-100" : "before:to-red-100"
              }`}
    >
      <div className="flex flex-col flex-1">
        <TeamScore name={stats.game.local} score={stats.game.local_score} />
        <TeamScore name={stats.game.away} score={stats.game.away_score} />
      </div>
      <div className="flex gap-6">
        <PlayerGameInfo info={stats.minutes_played} icon={<MicroClockIcon />}>
          Min. played
        </PlayerGameInfo>
        <PlayerGameInfo info={stats.points} icon={<ScoreIcon />}>
          Points
        </PlayerGameInfo>
      </div>
    </li>
  );
}
