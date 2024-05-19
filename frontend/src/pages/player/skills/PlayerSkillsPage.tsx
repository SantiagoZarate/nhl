import { useState } from "react";
import { Skills } from "@/types/player";
import { AddSkillsForm } from "./AddSkillsForm";
import { SkillsChart } from "./SkillsChart";
import "./skills.css";

const INITIAL_SKILLS_STATE = {
  pace: 0,
  vision: 0,
  dribble: 0,
  defense: 0,
  physique: 0
}

export function PlayerSkillsPage() {
  const [skills, setSkills] = useState<Skills>(INITIAL_SKILLS_STATE)

  const changeSkills = (newSkills: Skills) => {
    setSkills(newSkills)
  }

  return (
    <section className="w-full grid grid-cols-1 sm:grid-cols-2 gap-8">
      <SkillsChart skills={skills} keys={["new", "reference"]} />
      <AddSkillsForm onChange={changeSkills} />
    </section>
  );
}
