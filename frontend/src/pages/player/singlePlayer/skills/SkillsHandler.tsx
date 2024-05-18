import { usePlayer } from "@/hooks/usePlayer";
import { useParams } from "react-router-dom";
import { PlayerRecentSkills } from "./PlayerRecentSkills";
import { SkillsChart } from "./SkillsChart";
import { NoSkills } from "./NoSkills";
import { SkillsLoader } from "./SkillsLoader";

export function SkillsHandler() {
  const { playerId } = useParams();
  const { isLoading, player } = usePlayer(playerId!);

  return (
    <PlayerRecentSkills>
      {/* Loading UI */}
      {isLoading && <SkillsLoader />}

      {/* Player has no skills tracked */}
      {!isLoading && !player?.skills && <NoSkills />}

      {/* Player has skills tracked */}
      {!isLoading && player?.skills && <SkillsChart skills={player?.skills!} />}
    </PlayerRecentSkills>
  );
}
