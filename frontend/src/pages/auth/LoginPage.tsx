import { Form, FormDescription, FormLabel, FormItem, FormMessage, FormField, FormControl } from '@ui/ui/form'
import { Input } from '@ui/ui/input'
import { Button } from '@ui/ui/button'
import { useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { z } from 'zod'
import { Link } from 'react-router-dom'
import { KeyIcon, UserIcon } from '@/components/icons'

const loginSchema = z.object({
  username: z.string(),
  password: z.string()
})

type LoginFormSchemaType = z.infer<typeof loginSchema>

export function LoginPage() {
  const form = useForm<LoginFormSchemaType>({
    resolver: zodResolver(loginSchema)
  })

  const onSubmit = (data: LoginFormSchemaType) => {
    console.log(data);
  };

  return (
    <article className='flex flex-col items-center gap-4'>
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="w-full flex flex-col space-y-8">
          <FormField
            control={form.control}
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
          <FormField
            control={form.control}
            name='password'
            render={({ field }) => (
              <FormItem>
                <FormLabel className='flex items-center gap-2'>
                  <KeyIcon />
                  Password
                </FormLabel>
                <FormControl>
                  <Input type='password' placeholder="******" {...field} />
                </FormControl>
                <FormDescription>
                  Generate a new password.
                </FormDescription>
                <FormMessage />
              </FormItem>
            )}
          />
          <Button type="submit">Log in</Button>
        </form>
      </Form >
      <footer className='flex items-center'>
        you've already had an account? <Link to={'/register'}>
          <Button variant={'link'}>
            click here!
          </Button>
        </Link>
      </footer>
    </article>
  )
}