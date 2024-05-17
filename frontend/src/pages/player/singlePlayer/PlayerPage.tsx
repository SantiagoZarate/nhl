import { usePlayer } from "@/hooks/usePlayer";
import { redirect, useParams } from "react-router-dom";
import { PlayerRatingStars } from "./PlayerRatingStars";

export function PlayerPage() {
  const { playerId } = useParams();
  const { isLoading, player } = usePlayer(playerId!);

  if (player === undefined || player === null) {
    redirect("/404");
  }

  if (isLoading) {
    return (
      <div className="flex items-center justify-center">Loading player...</div>
    );
  }

  return (
    <div>
      <section className="flex gap-6">
        <picture className="size-48 aspect-square">
          <img
            className="w-full h-full object-top"
            src="https://www.pngall.com/wp-content/uploads/5/User-Profile-PNG.png"
            alt=""
          />
        </picture>
        <article className="flex flex-1 flex-col gap-4">
          <h1 className="text-2xl">{player?.name}</h1>
          <ul className="flex divide-x *:px-4 [&>*:first-child]:pl-0">
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
    </div>
  );
}
