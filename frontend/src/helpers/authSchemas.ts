import { z } from 'zod'

export const loginSchema = z.object({
  username: z.string(),
  password: z.string()
})

export const registerSchema = loginSchema.extend({
  email: z.string().email()
})

export type LoginFormSchemaType = z.infer<typeof loginSchema>
export type RegisterFormSchemaType = z.infer<typeof registerSchema>
