import { Button } from "@/components/ui/button";
import { Link } from "react-router-dom";

export function NotFoundPage() {
  return (
    <div className="flex flex-col min-h-screen items-center justify-center gap-4">
      <h1 className="text-2xl">ERROR 404</h1>
      <p>Resource not found</p>
      <Link to="/">
        <Button variant={"default"} className="uppercase">
          go home
        </Button>
      </Link>
    </div>
  )
}
