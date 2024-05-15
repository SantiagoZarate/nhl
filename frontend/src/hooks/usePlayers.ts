import { getAllPlayers } from "@/api/players/getAllPlayers";
import { Playerr } from "@/types/player";
import { useEffect, useState } from "react";

export function usePlayers() {
  const [players, setPlayers] = useState<Playerr[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    getAllPlayers()
      .then((res) => res.results)
      .then((res) => setPlayers(res))
      .finally(() => setIsLoading(false));
  }, []);

  return {
    players,
    isLoading,
  };
}
