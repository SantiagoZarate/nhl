import { Button } from '@ui/ui/button'
import { FormProvider, useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { Link } from 'react-router-dom'
import { LoginFormSchemaType, loginSchema } from '@/helpers/authSchemas'
import { PasswordField } from './PasswordField'
import { UsernameField } from './UsernameField'
import { EmailField } from './EmailField'

export function RegisterPage() {
  const form = useForm<LoginFormSchemaType>({
    resolver: zodResolver(loginSchema)
  })

  const onSubmit = (data: LoginFormSchemaType) => {
    console.log(data);
  };

  return (
    <article className='flex flex-col items-center gap-4'>
      <FormProvider {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="w-full flex flex-col space-y-8">
          <UsernameField />
          <EmailField />
          <PasswordField />
          <Button type="submit">Sign up</Button>
        </form>
      </FormProvider >
      <footer>
        you've already had an account? <Link to={'../login'} className='hover:underline'>
          click here!
        </Link>
      </footer>
    </article>
  )
}