import { MiniPlusIcon } from "@/components/icons";
import { Text } from "@/components/ui/Text";
import { Button } from "@/components/ui/button";
import { Link } from "react-router-dom";

export function NoSkills() {
  return (
    <div className="bg-secondary rounded-lg h-full w-full flex flex-col gap-2 items-center justify-center min-h-[300px]">
      <Text>there is no record about this player skills...</Text>
      <Link to={"./skills#add"}>
        <Button variant={"outline"} className="gap-1">
          <MiniPlusIcon />
          add records
        </Button>
      </Link>
    </div>
  );
}
