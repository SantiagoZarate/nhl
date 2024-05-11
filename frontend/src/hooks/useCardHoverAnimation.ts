import { useRef } from "react";

export type CardRefType = HTMLAnchorElement & {
  posY: string,
  scale: string
}

const INIT_SCALE = "100%";
const INIT_POS_Y = "0px";

export function useCardHoverAnimation(){
  const cardsRef = useRef<CardRefType[] | null>([]);
  
  const handleMouseHover = () => {
    if (cardsRef.current === null) {
      return;
    }

    cardsRef.current!.forEach(current => {
      // Guardo estilo de cada carta
      current.posY = current.style.translate;
      current.scale = current.style.scale;

      current.style.translate = INIT_POS_Y;
      current.style.scale = INIT_SCALE;
    })
  }

  const handleMouseLeave = () => {
    if (cardsRef.current === null) {
      return;
    }

    // Restauro el estilo de cada carta
    cardsRef.current!.forEach(current => {
      current.style.translate = current.posY;
      current.style.scale = current.scale;
    })
  }

  return{
    handleMouseHover,
    handleMouseLeave,
    cardsRef
  }
}