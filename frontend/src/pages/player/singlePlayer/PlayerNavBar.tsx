import { BadgetLink } from "@/components/ui/BadgetLink";
import { playerLinks } from "@/data/constants";
import { useLocation } from "react-router-dom";

export function PlayerNavBar() {
  const { pathname } = useLocation();
  const lastSegment = pathname.split("/").pop();
  const currentPath = lastSegment?.includes("-") ? "general" : lastSegment;

  return (
    <header className="w-full  flex justify-center">
      <nav className="flex gap-3">
        {playerLinks.map((link) => (
          <BadgetLink
            key={link.value}
            path={link.path}
            isActive={currentPath === link.value}
          >
            {link.value}
          </BadgetLink>
        ))}
      </nav>
    </header>
  );
}
