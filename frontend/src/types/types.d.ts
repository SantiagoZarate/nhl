export interface Team {
  name: string;
  captain: string;
  image_url: string;
}

export interface Player {
  id: string;
  name: string;
  team: string;
  points: number;
}

export interface Match {
  id: string;
  winner: string;
  guest_team: string;
  host_team: string;
  score: string;
  mvp: string;
}
