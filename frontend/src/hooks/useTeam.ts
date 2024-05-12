import { getAllTeams } from "@/api/teams/getAllTeams";
import { Team } from "@type/types";
import { useEffect, useState } from "react";

export function useTeam(teamName: string) {
  const [team, setTeam] = useState<Team>();

  useEffect(() => {
    getAllTeams()
      .then((res: Team[]) => setTeam(res.find(t => t.name === teamName)))
  }, [])

  return {
    team
  }
}