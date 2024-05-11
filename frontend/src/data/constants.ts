import { Player, Team } from "@/types";

export const players: Player[] = [
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
    points: 123,
  },
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
    points: 79,
  },
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
    points: 77,
  },
  {
    id: crypto.randomUUID(),
    name: "Jhon Doe",
    team: "Buffalo",
    points: 67,
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
  {
    image_url:
      "https://loodibee.com/wp-content/uploads/nhl-colorado-avalanche-logo-300x300.png",
    captain: "Jhon Doe",
    name: "Colorado Locura",
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
