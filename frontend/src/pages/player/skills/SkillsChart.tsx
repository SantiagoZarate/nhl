import { mapSkills } from "@/helpers/mapSkills";
import { Skills } from "@/types/player";
import { ResponsiveRadar } from "@nivo/radar";

interface Props {
  keys: string[];
  skills: Skills
}

export function SkillsChart({ skills, keys }: Props) {
  const data = mapSkills({ skills, key: keys[0] })
  return (
    <article className="bg-secondary rounded-lg min-h-[300px]">
      <ResponsiveRadar
        data={data}
        keys={keys}
        indexBy={"skill"}
        valueFormat=">-.2f"
        margin={{ top: 70, right: 80, bottom: 20, left: 80 }}
        dotColor={{ theme: "background" }}
        colors={{ scheme: "set1" }}
        legends={[
          {
            anchor: "top-left",
            direction: "column",
            translateX: -50,
            translateY: -40,
            itemWidth: 80,
            itemHeight: 20,
            itemTextColor: "#999",
            symbolSize: 12,
            symbolShape: "circle",
          },
        ]}
      />
    </article>
  )
}
