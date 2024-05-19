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


interface Props {
  onChange: (skills: Skills) => void
}

export function AddSkillsForm({ onChange }: Props) {
  const { elementRef } = useFocusElement();
  const form = useForm<SkillsForm>({
    resolver: zodResolver(formSchema)
  });

  const onSubmit = (data: SkillsForm) => {
    console.log(data);
  };

  return (
    <article
      ref={elementRef}
      id="add-skills"
      className="min-h-[300px] rounded-lg bg-border p-4"
    >
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} onChange={() => onChange(mapFormValuesToState(form.getValues()))} className="space-y-4">
          {
            skillsFields.map(f => (
              <FormField
                key={f}
                control={form.control}
                name={f}
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
            ))
          }
          <Button type="submit">Submit</Button>
        </form>
      </Form>
    </article>
  )
}
