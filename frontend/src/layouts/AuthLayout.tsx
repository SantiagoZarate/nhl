import { Outlet } from "react-router-dom";

export function AuthLayout() {
  return (
    <section className="grid grid-cols-2 items-center gap-4">
      <article className="rounded-md shadow-md overflow-hidden">
        <img
          className="w-full h-full object-cover"
          src="https://i.pinimg.com/736x/61/ef/c9/61efc9348bf57f41647993f1cb3174db.jpg"
          alt="" />
      </article>
      <article>
        <Outlet />
      </article>
    </section>
  )
}