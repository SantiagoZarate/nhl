import { getAllTeams } from "@/api/teams/getAllTeams";
import { TeamMinified } from "@/types/player";
import { useEffect, useState } from "react";

export function useTeams() {
  const [teams, setTeams] = useState<TeamMinified[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    getAllTeams()
      .then(res => setTeams(res))
  }, [])

  // Delay to see Loader
  useEffect(() => {
    setTimeout(() => {
      setIsLoading(false)
    }, 2000)
  }, [])


  const separatedTeamsByRegion = [{
    region: "east",
    teams: teams.filter(team => team.region === 'east')
  },
  {
    region: "west",
    teams: teams.filter(team => team.region === 'west')
  }
  ]

  const firstFiveTeams = teams.slice(0, 5);

  return {
    isLoading,
    teams,
    firstFiveTeams,
    separatedTeamsByRegion
  }
}