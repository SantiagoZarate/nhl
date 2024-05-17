import { Playerr } from "@/types/player";

const API_URL = import.meta.env.VITE_API_URL;

export function getPlayerByID(playerID: string): Promise<Playerr> {
  console.log("Fetching player with ID: " + playerID);

  return fetch(API_URL + "/players/" + playerID).then((res) => res.json());
}
