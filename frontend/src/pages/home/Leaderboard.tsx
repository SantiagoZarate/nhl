import { teams } from "@/data/constants";
import { useRef } from "react";
import { Link } from "react-router-dom";

type CardRefType = HTMLAnchorElement & {
  posY: string,
  scale: string
}

export function Leaderboard() {
  const cardsRef = useRef<CardRefType[] | null>([]);

  const handleMouseHover = () => {
    if (cardsRef.current === null) {
      return;
    }

    cardsRef.current!.forEach(current => {
      // Guardo estilo de cada carta
      current.posY = current.style.translate;
      current.scale = current.style.scale;

      current.style.translate = "0px";
      current.style.scale = "100%";
    })
  }

  const handleMouseLeave = () => {
    if (cardsRef.current === null) {
      return;
    }

    // Restauro el estilo de cada carta
    cardsRef.current!.forEach(current => {
      current.style.translate = current.posY;
      current.style.scale = current.scale;
    })
  }

  return (
    <article onMouseLeave={handleMouseLeave}
      onMouseEnter={handleMouseHover} className="flex-1 flex flex-col gap-4">
      <h1 className="">Leaderboard</h1>
      <ul className="relative flex flex-col gap-4 before:z-10 before:hover:opacity-25 before:transition before:duration-500 before:inset-0 before:absolute before:bg-gradient-to-b before:from-transparent before:to-background before:pointer-events-none p-4 ">
        {teams.map((team, index) => (
          <Link key={team.name} to={`/team/` + team.name}
            ref={el => cardsRef.current![index] = el as any}
            style={{
              translate: `0px -${index * 6 * index}px`,
              scale: `${100 - index * 5}%`,
              zIndex: `${5 - index}`
            }}
            className="rounded-xl shadow-lg border border-border p-4 flex justify-between bg-background items-center gap-2 transition-all duration-500 hover:-translate-y-1 hover:bg-secondary">
            <p>{team.name}</p>
            <picture className="size-8">
              <img
                className=" object-cover w-full h-full"
                src={team.image_url}
                alt=""
              />
            </picture>
          </Link>
        ))}
      </ul>
    </article>
  )
}
