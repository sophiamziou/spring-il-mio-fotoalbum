import { reactive } from "vue";

export const store = reactive({
  url: "http://localhost:8080/api/foto",
  fotos: [],
});
