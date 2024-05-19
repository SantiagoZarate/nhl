import { Skills } from "@/types/player";

interface SkillChartData {
  skill: string;
  [y: string]: any;
}

interface Options {
  key?: string;
  skills: Skills
}

export function mapSkills({ skills, key = "2024" }: Options): SkillChartData[] {
  const data: SkillChartData[] = [];

  Object.keys(skills).forEach((skill) => {
    const newSkill = {
      skill: skill,
      reference: 100,
    };
    Object.defineProperty(newSkill, key, {
      value: skills[skill as keyof Skills],
      writable: true,
      enumerable: true,
      configurable: true,
    });

    data.push(newSkill);
  });
  return data;
}
