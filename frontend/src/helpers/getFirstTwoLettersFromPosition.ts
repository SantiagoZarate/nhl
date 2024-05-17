export function getFirstTwoLetters(position: string) {
  const array = position.split(" ");

  if (array.length === 1) {
    return array[0][0].toUpperCase() + array[0][1].toUpperCase();
  }
  return array[0][0].toUpperCase() + array[1][0].toUpperCase();
}
