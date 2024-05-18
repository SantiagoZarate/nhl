import { HockeyArenaIcon } from "@/components/icons";
import { Subheader } from "@/components/ui/Subheader";
import { PropsWithChildren } from "react";

interface Props extends PropsWithChildren {}

export function PlayerRecentGames({ children }: Partial<Props>) {
  return (
    <section className="flex flex-col gap-4">
      <Subheader icon={<HockeyArenaIcon />}>recent games</Subheader>
      {children}
    </section>
  );
}
