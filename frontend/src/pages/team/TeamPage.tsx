import { useTeam } from "@/hooks/useTeam";
import { redirect, useParams } from "react-router-dom"

export function TeamPage() {
  const { teamName } = useParams();
  const { team } = useTeam(teamName!);

  if (team === null || team === undefined) {
    redirect("/404");
  }

  console.log(team!.image_url);

  return (
    <div className="flex flex-col gap-8 p-8">
      <section>
        <picture className="aspect-square ">
          <img src="" alt="" />
        </picture>
      </section>
    </div>
  )
}
