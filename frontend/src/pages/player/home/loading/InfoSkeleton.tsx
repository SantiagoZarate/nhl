export function InfoSkeleton() {
  return (
    <section className="flex gap-6">
      <picture className="size-48 aspect-square rounded-2xl overflow-hidden shadow border-4 border-border">
        <img className="w-full h-full object-top" draggable={false} alt="" />
      </picture>
      <article className="flex flex-1 flex-col gap-4">
        <h1 className="h-6 w-1/2 bg-border"></h1>
        <ul className="flex items-center divide-x *:px-4 [&>*:first-child]:pl-0">
          <p>teamName</p>
          <p>nationality</p>
          <p>21 Years Old</p>
        </ul>
        <div className="flex items-center gap-4">Player Rating:</div>
        <footer className="flex items-center gap-2 rounded-full h-4 w-12 bg-border" />
      </article>
    </section>
  );
}
