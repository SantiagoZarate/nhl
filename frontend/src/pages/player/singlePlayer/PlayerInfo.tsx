import { PlayerRatingStars } from "./PlayerRatingStars";

interface Props {
  name: string;
  teamName: string;
  nationality: string;
  skillLevel: number;
}

export function PlayerInfo({
  name,
  nationality,
  skillLevel,
  teamName,
}: Partial<Props>) {
  return (
    <article className="flex flex-1 flex-col gap-4">
      <h1 className="text-2xl">{name}</h1>
      <ul className="flex items-center divide-x *:px-4 [&>*:first-child]:pl-0">
        <p>{teamName}</p>
        <p>{nationality}</p>
        <p>21 Years Old</p>
      </ul>
      <div className="flex items-center gap-4">
        Player Rating:
        <PlayerRatingStars skillLevel={skillLevel!} />
      </div>
      <footer className="w-fit flex items-center gap-2 rounded-full px-4 py-1 bg-green-200">
        <div className="size-2 rounded-full bg-green-500" />
        <span className="text-xs text-green-500 uppercase">active</span>
      </footer>
    </article>
  );
}
