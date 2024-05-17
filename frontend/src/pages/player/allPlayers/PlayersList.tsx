import { Player } from "@/types/player";
import { Link } from "react-router-dom";

interface Props {
  players: Player[];
}

export function PlayersList({ players }: Props) {
  return (
    <ul className="flex flex-col divide-y">
      {players.map((player) => (
        <Link to={"/players/" + player.id} className="p-2 flex justify-between">
          <p>{player.name}</p>
          <p>{player.position}</p>
        </Link>
      ))}
    </ul>
  );
}
