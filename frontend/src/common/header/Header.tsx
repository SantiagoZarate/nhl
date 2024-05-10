import { links } from "@data/constants";
import { Link } from "react-router-dom";

export function Header() {
  return (
    <header className="absolute w-full">
      <div className="max-w-screen-lg py-12 flex justify-between items-center mx-auto">
        <nav className="flex gap-4">
          {links.map((link) => (
            <Link className="uppercase text-sm" to={link.path}>
              {link.value}
            </Link>
          ))}
        </nav>
        <div>login</div>
      </div>
    </header>
  );
}
