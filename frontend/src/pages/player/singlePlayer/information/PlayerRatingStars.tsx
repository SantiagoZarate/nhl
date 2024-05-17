import { SolidStarIcon, OutlineStarIcon } from "@/components/icons";
import { ReactNode } from "react";

interface Props {
  skillLevel: number;
}

export function PlayerRatingStars({ skillLevel }: Props) {
  const rating: ReactNode[] = [];
  for (let i = 0; i < 5; i++) {
    i < skillLevel
      ? rating.push(<SolidStarIcon key={i} />)
      : rating.push(<OutlineStarIcon key={i} />);
  }

  return <ul className="flex">{rating}</ul>;
}
