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

export interface Playerr {
  id: string;
  name: string;
  image_url: string;
  nationality: string;
  position: string;
  skill_level: number;
  skills: Skills;
  injuries: Injury[];
  team: Team;
}

export interface Injury {
  description: string;
  start: Date;
  finish: Date;
}

export interface Skills {
  defense: number;
  pace: number;
  physique: number;
  dribble: number;
  vision: number;
}

export interface TeamMinified {
  name: string;
  city: string;
  image_url: string;
}