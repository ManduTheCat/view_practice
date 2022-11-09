<template>
  <div class="container">
    <h2>영화 상세 정보</h2>
    <fieldset class="detail-content">
      <label for="title">제목</label>
      <div class="view">{{ movie.title }}</div>
      <label for="director">감독</label>
      <div class="view">{{ movie.director }}</div>
      <label for="genre">장르</label>
      <div class="view">{{ movie.genre }}</div>
      <label for="runningTime">상영시간</label>
      <div class="view">{{ movie.runningTime }}</div>
      <!-- 구조만 잡아놓기 -->
      <button class="btn" @click="update">수정</button>
      <button class="btn">삭제</button>
    </fieldset>
  </div>
</template>
<script>
export default {
  props: {
    movie: {
      type: Object,
    },
  },
  methods: {
    update() {},
  },
};
</script>
