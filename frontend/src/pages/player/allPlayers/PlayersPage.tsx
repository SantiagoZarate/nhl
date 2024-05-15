import { usePlayers } from "@/hooks/usePlayers";
import { PlayersList } from "./PlayersList";

export function PlayersPage() {
  const { players, isLoading } = usePlayers();

  return (
    <section className="flex flex-col gap-8">
      <header className="">
        <h2 className="text-2xl">Players list</h2>
      </header>
      {isLoading ? <p>Loading...</p> : <PlayersList players={players} />}
    </section>
  );
}
