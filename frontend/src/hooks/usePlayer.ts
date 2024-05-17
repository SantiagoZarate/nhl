import { getPlayerStatsByPlayer } from "@/api/playerStats/getPlayerStatsByPlayer";
import { getPlayerByID } from "@/api/players/getPlayerByID";
import { PlayerStats } from "@/types/playerStats";
import { type Player } from "@type/player";
import { useEffect, useState } from "react";

export function usePlayer(playerID: string) {
  const [player, setPlayer] = useState<Player | null>(null);
  const [error, setError] = useState(false);
  const [isLoading, setIsLoading] = useState(false);

  const [stats, setStats] = useState<PlayerStats[]>([]);
  const [statsIsLoading, setStatsIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    getPlayerByID(playerID)
      .then((res) => {
        res.name === null ? setError(true) : setPlayer(res);
      })
      .catch(() => setError(true))
      .finally(() => setIsLoading(false));
  }, []);

  useEffect(() => {
    setStatsIsLoading(true);
    getPlayerStatsByPlayer(playerID)
      .then((res) => setStats(res))
      .finally(() => setStatsIsLoading(false));
  }, []);

  return {
    player,
    isLoading,
    stats,
    statsIsLoading,
    error,
  };
}
