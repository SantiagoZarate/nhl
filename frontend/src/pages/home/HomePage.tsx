import { players, teams } from "@data/constants";

export function HomePage() {
  return (
    <div className="p-8 flex flex-col gap-8">
      <h2 className="text-3xl">NHL League</h2>
      <section className="flex gap-8">
        <article className="flex-1 flex flex-col gap-4">
          <h1 className="">League players</h1>
          <ul className="flex flex-col divide-y">
            {players.map((player) => (
              <li className="p-2">{player.name}</li>
            ))}
          </ul>
        </article>
        <article className="flex-1">
          <ul className="flex flex-col gap-4">
            {teams.map((team) => (
              <li className="rounded-xl shadow-lg border border-border p-4 flex justify-between items-center gap-2">
                <p>{team.name}</p>
                <picture className="size-8">
                  <img
                    className=" object-cover w-full h-full"
                    src={team.image_url}
                    alt=""
                  />
                </picture>
              </li>
            ))}
          </ul>
        </article>
      </section>
    </div>
  );
}
