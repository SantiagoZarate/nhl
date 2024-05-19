import type { TeamMinified } from "@/types/player"
import { Text } from "./Text"

interface Props {
  team: TeamMinified,
  showCity?: boolean
}

export function TeamCard({ team: { image_url, name, city }, showCity = false }: Props) {
  return (
    <div className="rounded-xl shadow-lg border border-border px-4 py-2 flex justify-between bg-background items-center gap-2 hover:bg-secondary hover:-translate-y-1 transition">
      <div className="flex flex-col gap-1 ">
        <Text>
          {name}
        </Text>
        {showCity && <Text intent={'detail'}>{city}</Text>}
      </div>
      <picture className="size-8">
        <img
          className=" object-cover w-full h-full"
          src={image_url}
          draggable={false}
          alt={name + " team picture"}
        />
      </picture>
    </div>
  )
}