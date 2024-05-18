import { Header } from "../common/header/Header";
import { Outlet } from "react-router-dom";

export function AppLayout() {
  return (
    <div className="bg-background">
      <Header />
      <section className="pt-28 px-8 pb-8 max-w-screen-lg mx-auto min-h-screen">
        <Outlet />
      </section>
    </div>
  );
}
