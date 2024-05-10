import { defineConfig } from "vite";
import react from "@vitejs/plugin-react-swc";
import path from "node:path";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "src/*"),
      "@ui": path.resolve(__dirname, "src/components/*"),
      "@data": path.resolve(__dirname, "src/data/*"),
      "@util": path.resolve(__dirname, "src/utils/*"),
      "@page": path.resolve(__dirname, "src/pages/index.ts"),
    },
  },
});
