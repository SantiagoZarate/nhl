import { HockeyPlayerIcon } from "@/components/icons";
import { Subheader } from "@/components/ui/Subheader";
import { Skills } from "@/types/player";

import { ResponsiveRadar } from "@nivo/radar";

interface Props {
  skills: Skills;
}

interface SkillData {
  skill: string;
  [y: string]: any;
}

function mapSkills(skills: Skills) {
  const data: SkillData[] = [];

  Object.keys(skills).map((skill) => {
    const newSkill = {
      skill: skill,
      "2024": skills[skill as keyof Skills],
      reference: 100,
    };
    data.push(newSkill);
  });
  console.log(data);
  return data;
}

export function PlayerRecentSkills({ skills }: Props) {
  const data = mapSkills(skills);
  return (
    <div className="relative w-full h-48 flex flex-col gap-4">
      <Subheader icon={<HockeyPlayerIcon />}>Last year skills</Subheader>
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
          colors={{ scheme: "category10" }}
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
    </div>
  );
}
