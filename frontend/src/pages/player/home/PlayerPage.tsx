import { MainInfo } from "./information/MainInfo";
import { RecentGamesHandler } from "./recentGames/RecentGamesHandler";
import { SkillsHandler } from "./skills/SkillsHandler";

export function PlayerPage() {
  return (
    <div className="flex flex-col gap-8">
      <MainInfo />
      <section className="grid gap-8 grid-cols-1 sm:grid-cols-2">
        <SkillsHandler />
        <RecentGamesHandler />
      </section>
    </div>
  );
}
