import { Team } from "@type/types";

export function getAllTeams(): Promise<Team[]> {
  return fetch("http://localhost:5173/src/data/teams.json")
    .then(res => res.json())
}