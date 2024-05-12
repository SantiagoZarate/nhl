import { getPlayerByID } from "@/api/players/getPlayerByID";
import { type Playerr } from "@/types";
import { useEffect, useState } from "react";

export function usePlayer(playerID: string) {
  const [player, setPlayer] = useState<Playerr | null>(null);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true)
    getPlayerByID(playerID)
      .then((res: Playerr[]) => res.find(res => res.id === playerID))
      .then(res => setPlayer(res!))
      .finally(() => setIsLoading(false))
  }, [])

  return {
    player,
    isLoading
  }
}