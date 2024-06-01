import { LetterIcon } from "@/components/icons";
import { FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { RegisterFormSchemaType } from "@/helpers/authSchemas";
import { useFormContext } from "react-hook-form";

export function EmailField() {
  const { control } = useFormContext<RegisterFormSchemaType>();

  return (
    <FormField
      control={control}
      name='email'
      render={({ field }) => (
        <FormItem>
          <FormLabel className='flex items-center gap-2'>
            <LetterIcon />
            email
          </FormLabel>
          <FormControl>
            <Input placeholder="lionelcuccitini@gmail.com" required {...field} />
          </FormControl>
          <FormDescription>
            Type in a valid email.
          </FormDescription>
          <FormMessage />
        </FormItem>
      )}
    />
  )
}