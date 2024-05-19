import { links } from "@/data/constants";
import { Link } from "react-router-dom";

export function NavBarLinks() {
  return (
    <nav className="flex gap-4">
      {links.map((link) => (
        <Link key={link.path} className="uppercase text-sm" to={link.path}>
          {link.value}
        </Link>
      ))}
    </nav>
  )
}
