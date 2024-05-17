import { PropsWithChildren } from "react";

interface Props extends PropsWithChildren {
  icon: JSX.Element;
}

export function Subheader({ icon, children }: Props) {
  return (
    <header className="flex items-center gap-2">
      <div className="bg-border rounded-xl p-2 text-secondary-foreground">
        {icon}
      </div>
      <h3 className="text-sm font-bold uppercase">{children}</h3>
    </header>
  );
}
