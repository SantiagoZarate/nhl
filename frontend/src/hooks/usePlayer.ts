import { getPlayerStatsByPlayer } from "@/api/playerStats/getPlayerStatsByPlayer";
import { getPlayerByID } from "@/api/players/getPlayerByID";
import { Player } from "@/types/player";
import { PlayerStats } from "@/types/playerStats";
import { useQuery } from "@tanstack/react-query";

export function usePlayer(playerID: string) {
  const player = useQuery<Player>({
    queryKey: ["player"],
    queryFn: () => getPlayerByID(playerID),
  });

  const playerStats = useQuery<PlayerStats[]>({
    queryKey: ["playerStats"],
    queryFn: () => getPlayerStatsByPlayer(playerID),
  });

  return {
    player: player.data,
    isLoading: player.isLoading,
    error: player.error,
    stats: playerStats.data,
    statsIsLoading: playerStats.isLoading,
  };
}
