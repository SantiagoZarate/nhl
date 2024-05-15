import { Playerr } from "@/types/player";

interface Props {
  players: Playerr[];
}

export function PlayersList({ players }: Props) {
  return (
    <ul className="flex flex-col divide-y">
      {players.map((player) => (
        <li className="p-2 flex justify-between">
          <p>{player.name}</p>
          <p>{player.position}</p>
        </li>
      ))}
    </ul>
  );
}
