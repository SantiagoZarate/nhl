import { ThreeBlobsLoader } from "@/components/loaders/ThreeBlobsLoader";
import { teams } from "@/data/constants";
import { useEffect, useRef, useState } from "react";
import { LeaderboardList } from "./LeaderboardList";

export type CardRefType = HTMLAnchorElement & {
  posY: string,
  scale: string
}

export function Leaderboard() {
  const cardsRef = useRef<CardRefType[] | null>([]);
  const [isLoading, setIsLoading] = useState(true);

  // Delay to see Loader
  useEffect(() => {
    setTimeout(() => {
      setIsLoading(false)
    }, 2000)
  }, [])

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
    <article
      onMouseLeave={handleMouseLeave}
      onMouseEnter={handleMouseHover}
      className="flex-1 flex flex-col gap-4">
      <h1 className="">Leaderboard</h1>
      {isLoading
        ? <ThreeBlobsLoader />
        : <LeaderboardList cardsRef={cardsRef} teams={teams} />
      }
    </article>
  )
}
