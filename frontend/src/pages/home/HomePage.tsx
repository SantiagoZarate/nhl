import { Header } from "./Header";
import { Leaderboard } from "./Leaderboard";
import { MaxScorers } from "./MaxScorers";

export function HomePage() {
  return (
    <div className="p-8 flex flex-col gap-8">
      <Header />
      <section className="flex gap-4">
        <MaxScorers />
        <Leaderboard />
      </section>
    </div>
  );
}
