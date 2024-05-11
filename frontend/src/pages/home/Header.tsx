export function Header() {
  return (
    <header className="flex justify-between gap-4 items-center">
      <div className="flex gap-4 items-center">
        <picture className="size-12 p-2 bg-border rounded-xl">
          <img
            className="w-full h-full"
            src="https://upload.wikimedia.org/wikipedia/en/3/3a/05_NHL_Shield.svg"
            alt=""
          />
        </picture>
        <h2 className="text-3xl">NHL League</h2>
      </div>
      <div>
        Season 2023/24
      </div>
    </header>
  )
}
