<script>
import { store } from "./store";
import axios from 'axios';

export default {
  data() {
    return {
      store,
    };
  },
  created() {
    this.getFotos();
  },
  methods: {
    getFotos() {
      axios.get(store.url).then((response) => {
        store.fotos = response.data;
      })
        .catch((error) => {
          console.error('Errore durante la chiamata API:', error);
        });
    },
  },
};
</script>

<template></template>

<style scoped></style>
