import { usePlayers } from "@/hooks/usePlayers";
import { PlayersList } from "./PlayersList";

export function PlayersPage() {
  const { players, isLoading } = usePlayers();

  return (
    <section className="flex flex-col gap-8">
      <header className="flex gap-4 items-center">
        <picture className="size-8 bg-border p-1 rounded-lg">
          <img
            className="w-full h-full object-cover"
            src="/images/hockey_player.png"
            alt=""
          />
        </picture>
        <h2 className="text-2xl capitalize">Players List</h2>
      </header>
      {isLoading ? <p>Loading...</p> : <PlayersList players={players} />}
    </section>
  );
}
