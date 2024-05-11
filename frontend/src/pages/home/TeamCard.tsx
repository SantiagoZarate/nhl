import { Team } from "@/types"

interface Props {
  team: Team
}

export function TeamCard({ team: { image_url, name } }: Props) {
  return (
    <div className="rounded-xl shadow-lg border border-border p-4 flex justify-between bg-background items-center gap-2 hover:bg-secondary">
      <p>{name}</p>
      <picture className="size-8">
        <img
          className=" object-cover w-full h-full"
          src={image_url}
          alt=""
        />
      </picture>
    </div>
  )
}
