import { players, teams } from "@data/constants";
import { Link } from "react-router-dom";
import { Leaderboard } from "./Leaderboard";

export function HomePage() {
  return (
    <div className="p-8 flex flex-col gap-8">
      <header className="flex gap-4 items-center">
        <picture className="size-12 p-2 bg-border rounded-xl">
          <img
            className="w-full h-full"
            src="https://upload.wikimedia.org/wikipedia/en/3/3a/05_NHL_Shield.svg"
            alt=""
          />
        </picture>
        <h2 className="text-3xl">NHL League</h2>
      </header>
      <section className="flex gap-4">
        <article className="flex-1 flex flex-col gap-4">
          <h1 className="">League players</h1>
          <ul className="flex flex-col divide-y">
            {players.map((player, index) => (
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
        <Leaderboard />
      </section>
    </div>
  );
}
