import { usePlayer } from "@/hooks/usePlayer";
import { Link, redirect, useParams } from "react-router-dom";
import { PlayerRatingStars } from "./PlayerRatingStars";
import { PlayerPicture } from "./PlayerPicture";
import { MicroClockIcon } from "@/components/icons";
import { playerLins } from "@/data/constants";

export function PlayerPage() {
  const { playerId } = useParams();
  const { isLoading, player, stats, statsIsLoading } = usePlayer(playerId!);

  if (player === undefined || player === null) {
    redirect("/404");
  }

  if (isLoading) {
    return (
      <div className="flex items-center justify-center">Loading player...</div>
    );
  }

  return (
    <div className="flex flex-col gap-8">
      <header className="w-full  flex justify-center">
        <nav className="flex gap-3">
          {playerLins.map((link) => (
            <Link
              className="min-w-[80px] text-center capitalize text-sm px-4 py-1 rounded-full bg-secondary border border-border"
              to={link.path}
            >
              {link.value}
            </Link>
          ))}
        </nav>
      </header>
      <section className="flex gap-6">
        <PlayerPicture
          imageURL={
            "https://es.coachesvoice.com/wp-content/uploads/2023/05/bellingham_mobile.jpg"
          }
        />
        <article className="flex flex-1 flex-col gap-4">
          <h1 className="text-2xl">{player?.name}</h1>
          <ul className="flex items-center divide-x *:px-4 [&>*:first-child]:pl-0">
            <p>{player?.team.name}</p>
            <p>{player?.nationality}</p>
            <p>21 Years Old</p>
          </ul>
          <div className="flex items-center gap-4">
            Player Rating:
            <PlayerRatingStars skillLevel={player?.skill_level!} />
          </div>
        </article>
      </section>
      <section className="flex flex-col gap-2">
        <h3 className="text-sm font-bold uppercase">
          Most recent {player?.name} games
        </h3>
        <ul className="flex flex-col gap-4">
          {stats.map((stat) => (
            <li className="flex justify-between border border-border p-2 rounded-lg">
              <div className="flex flex-col flex-1">
                <div className="flex gap-3">
                  <p className="min-w-[140px]">{stat.game.away}</p>
                  <span>{stat.game.away_score}</span>
                </div>
                <div className="flex gap-3">
                  <p className="min-w-[140px]">{stat.game.local}</p>
                  <span>{stat.game.local_score}</span>
                </div>
              </div>
              <div className="flex gap-3">
                <p className="flex flex-col items-center">
                  <span className="text-xl">{stat.minutes_played}'</span>
                  <span className="flex items-center text-xs gap-1">
                    <MicroClockIcon />
                    Min. Played
                  </span>
                </p>
                <p className="flex flex-col items-center">
                  <span className="text-xl">{stat.points}</span>
                  <span className="text-xs">Points</span>
                </p>
              </div>
            </li>
          ))}
        </ul>
      </section>
    </div>
  );
}
