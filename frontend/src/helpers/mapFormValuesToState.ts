import { Skills } from "@/types/player";

export const mapFormValuesToState = (formValues: { [k: string]: any }) => {
  const ret = {};
  Object.keys(formValues).forEach(value => {
    const skillValue = formValues[value as keyof Skills] !== undefined
      ? parseInt(formValues[value as keyof Skills])
      : 0;

    Object.defineProperty(ret, value, {
      value: skillValue,
      writable: true,
      enumerable: true,
      configurable: true,
    })
  }
  )
  return ret as Skills
}