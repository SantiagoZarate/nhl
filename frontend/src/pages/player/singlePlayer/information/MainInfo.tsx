import { usePlayer } from "@/hooks/usePlayer";
import { InfoSkeleton } from "../loading/InfoSkeleton";
import { PlayerInfo } from "./PlayerInfo";
import { PlayerPicture } from "./PlayerPicture";
import { useParams } from "react-router-dom";

export function MainInfo() {
  const { playerId } = useParams();
  const { isLoading, player } = usePlayer(playerId!);

  return isLoading ? (
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
  );
}
