import { getFirstTwoLetters } from "@/helpers/getFirstTwoLettersFromPosition";
import { Player } from "@/types/player";
import { Link } from "react-router-dom";

interface Props {
  players: Player[];
}

export function PlayersList({ players }: Props) {
  return (
    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" className="px-6 py-3">
              Player name
            </th>
            <th scope="col" className="px-6 py-3">
              team
            </th>
            <th scope="col" className="px-6 py-3">
              position
            </th>
            <th scope="col" className="px-6 py-3">
              Market Price
            </th>
          </tr>
        </thead>
        <tbody>
          {players.map((player) => (
            <tr
              key={player.id}
              className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600"
            >
              <th
                scope="row"
                className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white"
              >
                <Link className="hover:underline" to={player.id}>
                  {player.name}
                </Link>
              </th>
              <td className="px-6 py-4">{player.team.name}</td>
              <td className="px-6 py-4">
                {getFirstTwoLetters(player.position)}
              </td>
              <td className="px-6 py-4">$10.5M</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
