import { PropsWithChildren } from "react";
import { Link } from "react-router-dom";

interface Props extends PropsWithChildren {
  isActive: boolean;
  path: string;
}

export function BadgetLink({ isActive, path, children }: Props) {
  return (
    <Link
      className={`min-w-[80px] text-center capitalize text-sm px-4 py-1 rounded-full border border-border transition duration-300 ${
        isActive && "bg-border"
      }`}
      to={path}
    >
      {children}
    </Link>
  );
}
