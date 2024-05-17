export function RecentGamesSkeleton() {
  return (
    <section className="flex flex-col gap-4">
      <div>Most recent games</div>
      <ul className="flex flex-col gap-4">
        {[1, 2, 3, 4, 5].map((index) => (
          <div key={index} className="h-16 rounded-lg bg-border" />
        ))}
      </ul>
    </section>
  );
}
