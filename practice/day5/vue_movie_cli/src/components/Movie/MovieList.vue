<template>
  <div class="container">
    <h2>영화 목록</h2>
    <h4>등록된 영화의 수 : {{ movieCnt }}</h4>
    <hr />
    <div v-if="mv.length">
      <table class="movie-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>ID</th>
            <th>제목</th>
            <th>감독</th>
            <th>장르</th>
            <th>상영시간</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(movie, index) in mv" :key="index">
            <td>{{ movie.id }}</td>
            <td>
              <a :href="'detail.html?id=' + movie.id">{{ movie.title }}</a>
            </td>
            <td>{{ movie.director }}</td>
            <td>{{ movie.genre }}</td>
            <td>{{ movie.runningTime }}분</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 영화가 없습니다.</div>
  </div>
</template>
<script>
export default {
  props: {
    mv: {
      type: Array,
    },
  },
  computed: {
    movieCnt() {
      return this.mv.length;
    },
  },
};
</script>
