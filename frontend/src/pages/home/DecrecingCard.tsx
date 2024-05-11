import { PropsWithChildren, forwardRef } from "react";
import { Link } from "react-router-dom";

interface Props extends PropsWithChildren {
  multiplier: number;
  path: string;
}

export const FowardDecrecingCard = forwardRef<HTMLAnchorElement, Props>(function DecrecingCard({ children, multiplier, path }: Props, ref) {
  const positionYmultiplier = multiplier * 6 * multiplier;
  const scaleMultiplier = 100 - multiplier * 4;
  const zIndexMultiplier = 50 - multiplier;

  return (
    <Link to={`/team/` + path}
      className="transition-all duration-500 hover:-translate-y-1"
      ref={ref}
      style={{
        translate: `0px -${positionYmultiplier}px`,
        scale: `${scaleMultiplier}%`,
        zIndex: `${zIndexMultiplier}`
      }}>
      {children}
    </Link>
  )
})
