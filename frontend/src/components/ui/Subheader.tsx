import { PropsWithChildren } from "react";
import { Text } from "./Text";
import { IconBadge } from "./IconBadge";

interface Props extends PropsWithChildren {
  icon: JSX.Element;
}

export function Subheader({ icon, children }: Props) {
  return (
    <header className="flex items-center gap-2">
      <IconBadge>{icon}</IconBadge>
      <Text intent={"subtitle"}>{children}</Text>
    </header>
  );
}
