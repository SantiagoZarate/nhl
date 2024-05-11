import { Team } from "@/types";
import { useEffect, useState } from "react";

export function useTeams() {
  const [teams, setTeams] = useState<Team[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:5173/src/data/teams.json")
      .then(res => res.json())
      .then((res: Team[]) => setTeams(res))
  }, [])

  // Delay to see Loader
  useEffect(() => {
    setTimeout(() => {
      setIsLoading(false)
    }, 2000)
  }, [])

  const firstFiveTeams = teams.slice(0, 5);

  return {
    isLoading,
    teams,
    firstFiveTeams
  }
}