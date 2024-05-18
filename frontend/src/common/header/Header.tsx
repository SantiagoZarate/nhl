import { Button } from "@/components/ui/button";
import { links } from "@data/constants";
import { Link } from "react-router-dom";

export function Header() {
  return (
    <header className="fixed z-50 w-full px-8 backdrop-blur-sm border-b">
      <div className="max-w-screen-lg py-8 flex justify-between items-center mx-auto">
        <nav className="flex gap-4">
          {links.map((link) => (
            <Link key={link.path} className="uppercase text-sm" to={link.path}>
              {link.value}
            </Link>
          ))}
        </nav>
        <div>
          <Button variant={"outline"}>login</Button>
        </div>
      </div>
    </header>
  );
}
