import { mapSkills } from "@/helpers/mapSkills";
import { Skills } from "@/types/player";
import { ResponsiveRadar } from "@nivo/radar";

interface Propps {
  skills: Skills;
}

export function SkillsChart({ skills }: Propps) {
  const data = mapSkills({ skills });
  return (
    <article className="bg-secondary rounded-lg min-h-[300px]">
      <ResponsiveRadar
        data={data}
        keys={["2024", "reference"]}
        indexBy="skill"
        valueFormat=">-.2f"
        margin={{ top: 70, right: 80, bottom: 20, left: 80 }}
        borderColor={{ from: "color" }}
        gridLabelOffset={26}
        dotSize={10}
        dotColor={{ theme: "background" }}
        dotBorderWidth={2}
        colors={{ scheme: "set1" }}
        blendMode="multiply"
        motionConfig="wobbly"
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
            effects: [
              {
                on: "hover",
                style: {
                  itemTextColor: "#000",
                },
              },
            ],
          },
        ]}
      />
    </article>
  );
}
