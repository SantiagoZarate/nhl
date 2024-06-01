import { UserIcon } from '@/components/icons';
import { LoginFormSchemaType } from '@/helpers/authSchemas';
import { FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage } from '@ui/ui/form';
import { Input } from '@ui/ui/input';
import { useFormContext } from 'react-hook-form';

export function UsernameField() {
  const { control } = useFormContext<LoginFormSchemaType>();

  return (
    <FormField
      control={control}
      name='username'
      render={({ field }) => (
        <FormItem>
          <FormLabel className='flex items-center gap-2'>
            <UserIcon />
            Username
          </FormLabel>
          <FormControl>
            <Input placeholder="LionelMessi10" {...field} />
          </FormControl>
          <FormDescription>
            This is your public display name.
          </FormDescription>
          <FormMessage />
        </FormItem>
      )}
    />
  )
}