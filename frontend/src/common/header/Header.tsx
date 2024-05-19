import { Button } from "@/components/ui/button";
import { NavBarLinks } from "./NavBarLinks";

export function Header() {
  return (
    <header className="fixed z-50 w-full px-8 backdrop-blur-sm border-b">
      <div className="max-w-screen-lg py-8 flex justify-between items-center mx-auto">
        <NavBarLinks />
        <div>
          <Button variant={"outline"}>login</Button>
        </div>
      </div>
    </header>
  );
}
