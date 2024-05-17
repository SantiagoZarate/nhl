export const DEFAULT_PLAYER_PICTURE =
  "https://www.pngall.com/wp-content/uploads/5/User-Profile-PNG.png";

export const topScorerPlayers = [
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

export const playerLinks = [
  {
    path: ".",
    value: "general",
  },
  {
    path: "./skills",
    value: "skills",
  },
  {
    path: "./games",
    value: "games",
  },
];
