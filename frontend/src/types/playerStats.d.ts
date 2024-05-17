export interface PlayerStats {
  id: string;
  points: number;
  minutes_played: number;
  game: Game;
}

export interface Game {
  id: string;
  mvp_player: string;
  local: string;
  away: string;
  local_score: number;
  away_score: number;
}
