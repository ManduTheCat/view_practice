<template>
  <div class="container">
    <h2>영화 등록</h2>
    <fieldset class="text-center">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="director">감독</label>
      <input type="text" id="director" v-model="director" class="view" /><br />
      <label for="genre">장르</label>
      <input type="text" id="overvivew" v-model="genre" class="view" /><br />
      <label for="runningTime">상영 시간</label>
      <input type="number" id="runningTime" v-model="runningTime" class="view" /><br />
      <button class="btn" @click="createMovie">등록</button>
    </fieldset>
  </div>
</template>
<script>
export default {
  name: "MoveCreate",
  data() {
    return {
      title: "",
      director: "",
      genre: "",
      runningTime: "",
    };
  },
  methods: {
    createMovie() {
      const newMovie = {
        id: 0,
        title: this.title,
        director: this.director,
        genre: this.genre,
        runningTime: this.runningTime,
      };
      this.$emit("send-data", newMovie);
    },
  },
};
</script>
