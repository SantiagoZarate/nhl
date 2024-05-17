export interface Player {
  id: string;
  name: string;
  image_url: string;
  nationality: string;
  position: string;
  skill_level: number;
  skills: Skills | null;
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
