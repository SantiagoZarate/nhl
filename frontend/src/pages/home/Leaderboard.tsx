import { ThreeBlobsLoader } from "@/components/loaders/ThreeBlobsLoader";
import { useCardHoverAnimation } from "@/hooks/useCardHoverAnimation";
import { useTeams } from "@/hooks/useTeams";
import { LeaderboardList } from "./LeaderboardList";

export function Leaderboard() {
  const { cardsRef, handleMouseHover, handleMouseLeave } = useCardHoverAnimation();
  const { isLoading, firstFiveTeams } = useTeams();

  return (
    <article
      onMouseLeave={handleMouseLeave}
      onMouseEnter={handleMouseHover}
      className="flex-1 flex flex-col gap-4">
      <h1 className="">Leaderboard</h1>
      {isLoading
        ? <ThreeBlobsLoader />
        : <LeaderboardList cardsRef={cardsRef} teams={firstFiveTeams} />
      }
    </article>
  )
}
