<template>
  <tr>
    <td>{{ article.articleno }}</td>
    <router-link :to="`/board/view/${article.articleno}`">
      <td>{{ article.subject }}</td>
    </router-link>
    <td>{{ article.userid }}</td>
    <td>{{ article.hit }}</td>
    <td>{{ article.regtime }}</td>
  </tr>
</template>

<script>
export default {
  name: "BoardListItem",
  props: {
    article: Object,
  },
};
</script>

<style></style>
