interface Props {
  name: string;
  score: number;
}

export function TeamScore({ name, score }: Props) {
  return (
    <div className="flex gap-3">
      <p className="min-w-[140px]">{name}</p>
      <span>{score}</span>
    </div>
  );
}
