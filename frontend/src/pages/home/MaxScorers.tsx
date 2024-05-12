import { topScorerPlayers } from "@/data/constants";

export function MaxScorers() {
  return (
    <article className="flex-1 flex flex-col gap-4">
      <h1 className="">League players</h1>
      <ul className="flex flex-col divide-y">
        {topScorerPlayers.map((player, index) => (
          <li key={player.id} className="p-2 flex justify-between items-center">
            <span
              className={` size-6 flex items-center justify-center text-xs rounded-full ${index < 3 ? "bg-yellow-200" : "bg-border"
                }`}
            >
              <span>{index + 1}</span>
            </span>
            <p>{player.name}</p>
            <span>{player.points}</span>
          </li>
        ))}
      </ul>
    </article>
  )
}
