import { Button } from '@ui/ui/button'
import { FormProvider, useForm } from 'react-hook-form'
import { zodResolver } from '@hookform/resolvers/zod'
import { Link } from 'react-router-dom'
import { LoginFormSchemaType, loginSchema } from '@/helpers/authSchemas'
import { PasswordField } from './PasswordField'
import { UsernameField } from './UsernameField'

export function LoginPage() {
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
          <PasswordField />
          <Button type="submit">Log in</Button>
        </form>
      </FormProvider >
      <footer>
        you don't have an account? <Link to={'../register'} className='hover:underline'>click here!</Link>
      </footer>
    </article>
  )
}