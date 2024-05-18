import { PropsWithChildren } from "react";

export function IconBadge({ children }: PropsWithChildren) {
  return (
    <div className="bg-border rounded-xl p-2 text-secondary-foreground">
      {children}
    </div>
  );
}
