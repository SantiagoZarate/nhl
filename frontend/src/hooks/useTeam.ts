import { Team } from "@/types";
import { useEffect, useState } from "react";

export function useTeam(teamName : string){
  const [team , setTeam] = useState<Team>();

  useEffect(() => {
    fetch("http://localhost:5173/src/data/teams.json")
    .then(res => res.json())
    .then((res : Team[]) => setTeam(res.find(t => t.name === teamName)))
  }, [])

  return{
    team
  }
}