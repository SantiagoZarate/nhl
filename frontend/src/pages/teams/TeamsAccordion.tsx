import { ShieldTeamIcon } from "@/components/icons";
import { Subheader } from "@/components/ui/Subheader";
import { TeamCard } from "@/components/ui/TeamCard";
import { Accordion, AccordionContent, AccordionItem, AccordionTrigger } from "@/components/ui/accordion";
import { useTeams } from "@/hooks/useTeams";
import { Link } from "react-router-dom";

export function TeamsAccordion() {
  const { separatedTeamsByRegion } = useTeams();

  return (
    <Accordion type="multiple" defaultValue={["east", "west"]} className="w-full ">
      {
        separatedTeamsByRegion.map(info => (
          <AccordionItem value={info.region}>
            <AccordionTrigger>
              <Subheader icon={<ShieldTeamIcon />}>
                {info.region} region
              </Subheader>
            </AccordionTrigger>
            <AccordionContent className="grid grid-cols-2 list-none gap-2 p-1 pt-2 pb-6">
              {info.teams.map(team => (
                <Link key={team.name} to={team.name}>
                  <TeamCard team={team} showCity />
                </Link>
              ))}
            </AccordionContent>
          </AccordionItem>
        ))
      }
    </Accordion>
  )
}
