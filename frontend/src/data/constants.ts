import { Player } from "@type/types";

export const topScorerPlayers: Player[] = [
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
