<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/qukka.gif" />

    <MovieContentVue></MovieContentVue>
    <MovieListVue></MovieListVue>
  </div>
</template>

<script>
// @ is an alias to /src

import MovieContentVue from "@/components/Movie/MovieContent.vue";

export default {
  name: "HomeView",
  components: {
    MovieContentVue,
  },
};
</script>
