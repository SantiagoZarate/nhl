import { DEFAULT_PLAYER_PICTURE } from "@/data/constants";

interface Props {
  imageURL?: string;
}

export function PlayerPicture({ imageURL }: Props) {
  const imgSrc = imageURL ? imageURL : DEFAULT_PLAYER_PICTURE;

  return (
    <picture className="size-48 aspect-square rounded-2xl overflow-hidden shadow border-4 border-border">
      <img
        className="w-full h-full object-top"
        draggable={false}
        src={imgSrc}
        alt=""
      />
    </picture>
  );
}
