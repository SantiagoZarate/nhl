import { VariantProps, cva } from "class-variance-authority";
import { ComponentProps } from "react";

const textStyle = cva("text-primary text-sm", {
  variants: {
    intent: {
      default: "first-letter:capitalize",
      subtitle: "font-bold uppercase tracking-wide",
    },
  },
  defaultVariants: {
    intent: "default",
  },
});

type Props = ComponentProps<"span"> & VariantProps<typeof textStyle>;

export function Text({ intent, ...args }: Props) {
  return <span className={textStyle({ intent })} {...args} />;
}
