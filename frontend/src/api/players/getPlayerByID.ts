const API_URL = import.meta.env.VITE_API_URL

export function getPlayerByID(playerID: string) {
  console.log("Fetching player with ID: " + playerID)

  return fetch(API_URL + "/players.json")
    .then(res => res.json())
}