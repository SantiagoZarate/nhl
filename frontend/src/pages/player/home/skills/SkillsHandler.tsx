import { usePlayer } from "@/hooks/usePlayer";
import { useParams } from "react-router-dom";
import { SkillsChart } from "../../skills/SkillsChart";
import { NoSkills } from "./NoSkills";
import { PlayerRecentSkills } from "./PlayerRecentSkills";
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
      {!isLoading && player?.skills && <SkillsChart skills={player.skills} keys={["2024", "reference"]} />}
    </PlayerRecentSkills>
  );
}
