import { Player, Team } from "@/types";

export const players: Player[] = [
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
  },
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
  },
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
  },
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
  },
];

export const teams: Team[] = [
  {
    image_url:
      "https://loodibee.com/wp-content/uploads/nhl-anaheim-ducks-logo-300x300.png",
    captain: "Jhon Doe",
    name: "Anaheim Ducks",
  },
  {
    image_url:
      "https://loodibee.com/wp-content/uploads/nhl-boston-bruins-logo-300x300.png",
    captain: "Jhon Doe",
    name: "Boston Bruins",
  },
  {
    image_url:
      "https://loodibee.com/wp-content/uploads/nhl-carolina-hurricanes-logo-300x300.png",
    captain: "Jhon Doe",
    name: "Carolina Hurricanes",
  },
  {
    image_url:
      "https://loodibee.com/wp-content/uploads/nhl-colorado-avalanche-logo-300x300.png",
    captain: "Jhon Doe",
    name: "Colorado Avalanche",
  },
];

export const links = [
  {
    path: "/",
    value: "home",
  },
  {
    path: "/teams",
    value: "teams",
  },
  {
    path: "/players",
    value: "players",
  },
  {
    path: "/matches",
    value: "matches",
  },
];
