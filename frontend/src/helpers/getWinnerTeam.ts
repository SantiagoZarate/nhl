import type { Game } from "@type/playerStats";
export function getWinnerTeam(game: Game): string {
  if (game.away_score === game.local_score) {
    return "empate";
  }

  return game.away_score > game.local_score ? game.away : game.local;
}
