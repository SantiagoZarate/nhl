import type { Player } from "@/types/player";
import type { APIPaginateResponse } from "@/types/apiResponse";

const API_URL = import.meta.env.VITE_API_URL;

export function getAllPlayers(): Promise<APIPaginateResponse<Player>> {
  return fetch(API_URL + "/players").then((res) => res.json());
}
