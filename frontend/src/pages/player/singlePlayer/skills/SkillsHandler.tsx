import { usePlayer } from "@/hooks/usePlayer";
import { useParams } from "react-router-dom";
import { PlayerRecentSkills } from "./PlayerRecentSkills";
import { SkillsChart } from "./SkillsChart";
import { NoSkills } from "./NoSkills";

export function SkillsHandler() {
  const { playerId } = useParams();
  const { isLoading, player } = usePlayer(playerId!);

  return (
    <PlayerRecentSkills>
      {isLoading ? <NoSkills /> : <SkillsChart skills={player?.skills!} />}
    </PlayerRecentSkills>
  );
}
