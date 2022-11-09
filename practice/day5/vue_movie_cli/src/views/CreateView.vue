<template>
  <createMovie @send-data="takeData"></createMovie>
</template>
<script>
import createMovie from "@/components/Movie/MovieCreate.vue";
export default {
  components: {
    createMovie,
  },
  methods: {
    takeData(newMovie) {
      const movieList = localStorage.getItem("movieList");
      let newMovieList = [];
      // 기존 로컬스토리지에 저장된 내용이 있다면 객체를 변경
      if (movieList) {
        newMovieList = JSON.parse(movieList);
      }
      newMovie.id = newMovieList.length + 1;
      // 입력된 데이터를 추가
      newMovieList.push(newMovie);
      // JSON -> 문자열 변환 후 로컬스토리지에 저장
      localStorage.setItem("movieList", JSON.stringify(newMovieList));
      alert("등록이 완료되었습니다.");
    },
  },
};
</script>
