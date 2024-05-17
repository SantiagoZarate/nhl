import { Skills } from "@/types/player";

interface SkillChartData {
  skill: string;
  [y: string]: any;
}

export function mapSkills(skills: Skills) {
  const data: SkillChartData[] = [];

  Object.keys(skills).map((skill) => {
    const newSkill = {
      skill: skill,
      "2024": skills[skill as keyof Skills],
      reference: 100,
    };
    data.push(newSkill);
  });
  return data;
}
