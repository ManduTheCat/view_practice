<template>
  <MovieDetailVue></MovieDetailVue>
</template>

<script>
import MovieDetailVue from "@/components/Movie/MovieDetail.vue";
export default {
  components: {
    MovieDetailVue,
  },
  data() {
    return {
      mvData: {},
    };
  },

  methods: {
    update() {
      alert("update");
    },
  },
};
</script>
