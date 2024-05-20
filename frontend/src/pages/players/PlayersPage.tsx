import { Button } from "@/components/ui/button";
import { Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle, DialogTrigger } from "@/components/ui/dialog";
import { FormControl, FormField, FormItem, FormLabel, FormMessage, Form } from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { usePlayers } from "@/hooks/usePlayers";
import { PlusCircleIcon } from "lucide-react";
import { PlayersList } from "./PlayersList";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from "@/components/ui/select";
import { PictureIcon } from "@/components/icons";

const playerSchema = z.object({
  name: z.string({ message: "Introduce a valid name" }),
  team: z.string({ message: "Choose a team" }),
  image_url: z.string().optional()
})

type PlayerFormType = z.infer<typeof playerSchema>

export function PlayersPage() {
  const { players, isLoading } = usePlayers();
  const form = useForm<PlayerFormType>({
    resolver: zodResolver(playerSchema)
  })

  const onSubmit = async (data: PlayerFormType) => {
    await new Promise((resolve) => { setTimeout(resolve, 2000) })
    console.log(data)
  }

  return (
    <section className="flex flex-col gap-8">
      <header className="flex gap-4 items-center justify-between">
        <div className="flex gap-2 items-center">
          <picture className="size-8 bg-border p-1 rounded-lg">
            <img
              className="w-full h-full object-cover"
              src="/images/hockey_player.png"
              alt=""
            />
          </picture>
          <h2 className="text-2xl capitalize">Players List</h2>
        </div>
        <Dialog>
          <DialogTrigger>
            <PlusCircleIcon />
          </DialogTrigger>
          <DialogContent>
            <DialogHeader>
              <DialogTitle>Add new player</DialogTitle>
              <Form {...form}>
                <form
                  onSubmit={form.handleSubmit(onSubmit)}
                  className="space-y-4 flex flex-col text-left gap-2">
                  <div className="flex flex-col gap-2">
                    <FormField
                      control={form.control}
                      name="name"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel>
                            Name
                          </FormLabel>
                          <FormControl>
                            <Input {...field} placeholder="Lionel Messi" />
                          </FormControl>
                          <FormMessage />
                        </FormItem>
                      )}
                    />
                    <FormField
                      control={form.control}
                      name="team"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel>
                            Team
                          </FormLabel>
                          <Select
                            onValueChange={field.onChange}
                            defaultValue={field.value} {...field}>
                            <FormControl>
                              <SelectTrigger>
                                <SelectValue placeholder="Select team" />
                              </SelectTrigger>
                            </FormControl>
                            <SelectContent>
                              <SelectItem value="light">River</SelectItem>
                              <SelectItem value="rassad">Real Madrid</SelectItem>
                              <SelectItem value="aasdasd">Manchester City</SelectItem>
                            </SelectContent>
                          </Select>
                          <FormMessage />
                        </FormItem>
                      )}
                    />
                  </div>
                  <div>
                    <FormField
                      control={form.control}
                      name="image_url"
                      render={({ field }) => (
                        <FormItem>
                          <FormLabel htmlFor="player_picture">
                            Imagen
                          </FormLabel>
                          <section className="flex gap-4">
                            <label htmlFor="player_picture" className="cursor-pointer aspect-square flex-1 flex items-center justify-center rounded-xl bg-accent hover:bg-border transition overflow-hidden">
                              {field.value
                                ? <img className="w-full h-full object-cover" src="#" alt="" />
                                : <div className="flex flex-col justify-center items-center gap-1">
                                  <PictureIcon />
                                  <p>add image</p>
                                </div>
                              }
                            </label>
                            <ul className="flex-1 flex flex-col gap-2">
                              <span className="italic text-xs">Optional</span>
                              <li>Player image should not be larger than 5mb</li>
                            </ul>
                          </section>
                          <FormControl className="hidden">
                            <Input id="player_picture" type="file" {...field} />
                          </FormControl>
                          <FormMessage />
                        </FormItem>
                      )}
                    />
                  </div>
                  <Button type="submit">{form.formState.isSubmitting ? "Enviando" : "Submit"}</Button>
                </form>
              </Form>
              <DialogDescription>
                This action cannot be undone. This will permanently delete your account
                and remove your data from our servers.
              </DialogDescription>
            </DialogHeader>
          </DialogContent>
        </Dialog>

      </header>
      {isLoading ? <p>Loading...</p> : <PlayersList players={players} />}
    </section>
  );
}
