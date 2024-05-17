import { playerLins } from "@/data/constants";
import { Link } from "react-router-dom";

export function PlayerNavBar() {
  return (
    <header className="w-full  flex justify-center">
      <nav className="flex gap-3">
        {playerLins.map((link) => (
          <Link
            key={link.value}
            className="min-w-[80px] text-center capitalize text-sm px-4 py-1 rounded-full bg-secondary border border-border"
            to={link.path}
          >
            {link.value}
          </Link>
        ))}
      </nav>
    </header>
  );
}
