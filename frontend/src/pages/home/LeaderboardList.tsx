import { Team } from "@/types";
import { FowardDecrecingCard } from "./DecrecingCard";
import { CardRefType } from "./Leaderboard";
import { TeamCard } from "./TeamCard";

interface Props {
  teams: Team[];
  cardsRef: React.MutableRefObject<CardRefType[] | null>;
}

export function LeaderboardList({ cardsRef, teams }: Props) {
  return (
    <ul className="relative flex flex-col gap-4 before:z-10 before:hover:opacity-25 before:transition before:duration-500 before:inset-0 before:absolute before:bg-gradient-to-b before:from-transparent before:to-80% before:to-background before:pointer-events-none p-4 ">
      {teams.map((team, index) => (
        <FowardDecrecingCard
          key={team.name}
          multiplier={index}
          path={team.name}
          ref={(el: HTMLAnchorElement | null) => {
            if (el) {
              cardsRef.current![index] = el as any;
            }
          }}>
          <TeamCard team={team} />
        </FowardDecrecingCard>
      ))}
    </ul>
  )
}
