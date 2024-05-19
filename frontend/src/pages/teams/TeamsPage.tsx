import { Text } from "@/components/ui/Text";
import { TeamsAccordion } from "./TeamsAccordion";

export function TeamsPage() {
  return (
    <section className="flex flex-col gap-4">
      <Text intent={'title'}>NHL teams</Text>
      <TeamsAccordion />
    </section>
  )
}
