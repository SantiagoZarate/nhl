import { TeamMinified } from "@/types/player";

export function getAllTeams(): Promise<TeamMinified[]> {
  return fetch("http://localhost:5173/src/data/teams.json")
    .then(res => res.json())
}