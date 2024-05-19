import { Button } from "@/components/ui/button";
import { FormField, FormItem, FormLabel, FormControl, FormMessage, Form } from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { skillsFields } from "@/data/constants";
import { SkillsForm, formSchema } from "@/helpers/addNewSkillSchema";
import { mapFormValuesToState } from "@/helpers/mapFormValuesToState";
import { useFocusElement } from "@/hooks/useFocusElement";
import { Skills } from "@/types/player";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import './input.css'

interface Props {
  onChange: (skills: Skills) => void;
  skills: Skills;
  resetSkills: () => void;
}

export function AddSkillsForm({ onChange, skills, resetSkills }: Props) {
  const { elementRef } = useFocusElement();
  const form = useForm<SkillsForm>({
    resolver: zodResolver(formSchema)
  });

  const onSubmit = (data: SkillsForm) => {
    resetSkills()
    console.log(data);
  };

  return (
    <article
      ref={elementRef}
      id="add-skills"
      className="min-h-[300px] rounded-lg bg-border p-4"
    >
      <Form {...form}>
        <form
          onSubmit={form.handleSubmit(onSubmit)}
          onChange={() => onChange(mapFormValuesToState(form.getValues()))}
          className="space-y-4 flex flex-col gap-4">
          {
            skillsFields.map(f => (
              <FormField
                key={f}
                control={form.control}
                name={f}
                render={({ field }) => (
                  <FormItem className="relative">
                    <FormLabel className="capitalize flex justify-between">
                      {f}
                      <div>
                        {skills[f]}
                      </div>
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="range"
                        min={0}
                        max={100}
                        {...field}
                        value={skills[f]}
                        className="slider p-0 h-fit"
                      />
                    </FormControl>
                    <div className="sliderticks">
                      <span>0</span>
                      <span>25</span>
                      <span>50</span>
                      <span>75</span>
                      <span>100</span>
                    </div>
                    <FormMessage />
                  </FormItem>
                )}
              />
            ))
          }
          <Button type="submit">Submit</Button>
        </form>
      </Form>
    </article>
  )
}
