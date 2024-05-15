export interface APIPaginateResponse<T> {
  results: T[];
  skip: number;
  total: number;
  limit: number;
}
