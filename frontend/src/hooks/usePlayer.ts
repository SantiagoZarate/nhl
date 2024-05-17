import { getPlayerByID } from "@/api/players/getPlayerByID";
import { type Playerr } from "@type/player";
import { useEffect, useState } from "react";

export function usePlayer(playerID: string) {
  const [player, setPlayer] = useState<Playerr | null>(null);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    getPlayerByID(playerID)
      .then((res) => setPlayer(res))
      .finally(() => setIsLoading(false));
  }, []);

  return {
    player,
    isLoading,
  };
}
