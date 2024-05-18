import { PropsWithChildren } from "react";

interface Props extends PropsWithChildren {
  icon: JSX.Element;
  info: number;
}

export function PlayerGameInfo({ icon, info, children }: Props) {
  return (
    <p className="flex flex-col items-center">
      <span className="text-xl italic font-bold">{info}</span>
      <span className="text-xs flex gap-1">
        {icon}
        {children}
      </span>
    </p>
  );
}
