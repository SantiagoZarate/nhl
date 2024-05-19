import { skillsFields } from "@/data/constants";
import { z } from "zod";

type FieldsType = (typeof skillsFields)[number];

// Define the reusable schema
const skillSchema = z.coerce
  .number()
  .max(100);

// Build the schema object dynamically
const schemaObject: { [k in FieldsType]: z.ZodSchema<any> } = skillsFields.reduce(
  (acc, skill) => {
    acc[skill] = skillSchema;
    return acc;
  },
  {} as { [k in FieldsType]: z.ZodSchema<any> }
);

// Create the final schema
export const formSchema = z.object(schemaObject);

export type SkillsForm = z.infer<typeof formSchema>;