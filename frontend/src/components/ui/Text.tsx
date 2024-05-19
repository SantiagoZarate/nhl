import { VariantProps, cva } from "class-variance-authority";
import { ComponentProps } from "react";

const textStyle = cva("text-primary", {
  variants: {
    intent: {
      default: "text-sm first-letter:capitalize",
      subtitle: "text-sm font-bold uppercase tracking-wide",
      title: "text-2xl capitalize font-bold",
      detail: "text-xs opacity-50 tracking-wider capitalize"
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
