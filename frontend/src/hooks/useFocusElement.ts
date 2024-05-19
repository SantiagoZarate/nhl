import { useRef, useEffect } from "react";
import { useLocation } from "react-router-dom";

export function useFocusElement() {
  const path = useLocation();
  const elementRef = useRef<HTMLElement | null>(null);

  useEffect(() => {
    if (elementRef.current === null) {
      return;
    }

    if (path.hash === "#add-skills") {
      elementRef.current.classList.add("focus-add-skill");
    }
  }, []);

  return {
    elementRef
  }
}