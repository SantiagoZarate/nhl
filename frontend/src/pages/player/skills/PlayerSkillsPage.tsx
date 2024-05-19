import { ChangeEvent, FormEvent, ReactNode, useEffect, useRef, useState } from "react";
import { useLocation } from "react-router-dom";

import { Button } from "@/components/ui/button";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { mapSkills } from "@/helpers/mapSkills";
import { Skills } from "@/types/player";
import { zodResolver } from "@hookform/resolvers/zod";
import { ResponsiveRadar } from "@nivo/radar";
import { useForm } from "react-hook-form";
import { z } from "zod";
import "./skills.css";

const mapFormValuesToState = (formValues: { [k: string]: any }) => {
  const ret = {};
  Object.keys(formValues).forEach(value => {
    const skillValue = formValues[value as keyof Skills] !== undefined
      ? parseInt(formValues[value as keyof Skills])
      : 0;

    Object.defineProperty(ret, value, {
      value: skillValue,
      writable: true,
      enumerable: true,
      configurable: true,
    })
  }
  )
  return ret as Skills
}

const skills = ["pace", "vision", "dribble", "defense", "physique"] as const;

type FieldsType = (typeof skills)[number];

// Define the reusable schema
const skillSchema = z.coerce
  .number()
  // .nonnegative({ message: "Value must be positive" })
  .max(100);

// Build the schema object dynamically
const schemaObject: { [k in FieldsType]: z.ZodSchema<any> } = skills.reduce(
  (acc, skill) => {
    acc[skill] = skillSchema;
    return acc;
  },
  {} as { [k in FieldsType]: z.ZodSchema<any> }
);

// Create the final schema
const formSchema = z.object(schemaObject);

type SkillsForm = z.infer<typeof formSchema>;

const INITIAL_SKILLS_STATE = {
  defense: 0,
  dribble: 0,
  pace: 0,
  physique: 0,
  vision: 0
}

export function PlayerSkillsPage() {
  const path = useLocation();
  const [skills, setSkills] = useState<Skills>(INITIAL_SKILLS_STATE)
  const addSkillsSection = useRef<HTMLElement | null>(null);
  const form = useForm<SkillsForm>({
    resolver: zodResolver(formSchema)
  });

  const mappedSkills = mapSkills({ skills, key: "new" });

  const formFields: ReactNode[] = [];
  Object.keys(formSchema.shape).forEach((f) => {
    formFields.push(
      <FormField
        key={f}
        control={form.control}
        name={f as FieldsType}
        render={({ field }) => (
          <FormItem className="space-y-0">
            <FormLabel className="capitalize">{f}</FormLabel>
            <FormControl>
              <Input
                type="range"
                min={0}
                max={100}
                defaultValue={["0"]}
                {...field}
                className="p-0"
              />
            </FormControl>
            <FormMessage />
          </FormItem>
        )}
      />
    );
  });

  useEffect(() => {
    if (addSkillsSection.current === null) {
      return;
    }

    if (path.hash === "#add-skills") {
      addSkillsSection.current.classList.add("focus-add-skill");
    }
  }, []);

  const handleChangeRange = () => {
    setSkills(mapFormValuesToState(form.getValues()))
  }

  const onSubmit = (data: SkillsForm) => {
    console.log(data);
  };

  return (
    <section className="w-full grid grid-cols-2 gap-8">
      <article className="bg-secondary rounded-lg">
        <ResponsiveRadar
          data={mappedSkills}
          keys={['new', 'reference']}
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
      <article
        ref={addSkillsSection}
        id="add-skills"
        className="min-h-[300px] rounded-lg bg-border p-4"
      >
        <Form {...form}>
          <form onSubmit={form.handleSubmit(onSubmit)} onChange={handleChangeRange} className="space-y-4">
            {formFields}
            <Button type="submit">Submit</Button>
          </form>
        </Form>
      </article>
    </section>
  );
}
