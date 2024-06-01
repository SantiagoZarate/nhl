import { LoginFormSchemaType } from '@/helpers/authSchemas';
import { FormField, FormItem, FormLabel, FormMessage, FormDescription, FormControl } from '@ui/ui/form'
import { useFormContext } from 'react-hook-form'
import { Input } from '@ui/ui/input'
import { KeyIcon } from '@/components/icons';

export function PasswordField() {
  const { control, register } = useFormContext<Pick<LoginFormSchemaType, 'password'>>();

  return (
    <FormField
      control={control}
      name='password'
      render={({ field }) => (
        <FormItem>
          <FormLabel className='flex items-center gap-2'>
            <KeyIcon />
            Password
          </FormLabel>
          <FormControl>
            <Input
              type='password'
              placeholder="******"
              {...register('password')} {...field} />
          </FormControl>
          <FormDescription>
            Generate a new password.
          </FormDescription>
          <FormMessage />
        </FormItem>
      )}
    />
  )
}