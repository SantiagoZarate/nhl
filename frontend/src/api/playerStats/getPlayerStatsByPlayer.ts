import { PlayerStats } from "@/types/playerStats";

const API_URL = import.meta.env.VITE_API_URL;

export function getPlayerStatsByPlayer(
  playerID: string
): Promise<PlayerStats[]> {
  return fetch(API_URL + "/player_stats/player/" + playerID).then((res) =>
    res.json()
  );
}
