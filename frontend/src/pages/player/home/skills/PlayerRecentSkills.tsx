import { HockeyPlayerIcon } from "@/components/icons";
import { Subheader } from "@/components/ui/Subheader";

import { PropsWithChildren } from "react";

interface Props extends PropsWithChildren {}

export function PlayerRecentSkills({ children }: Props) {
  return (
    <div className="relative w-full flex flex-col gap-4">
      <Subheader icon={<HockeyPlayerIcon />}>Last year skills</Subheader>
      {children}
    </div>
  );
}
