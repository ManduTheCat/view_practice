<template>
  <div>
    <b-table striped hover :items="items" :fields="fields"></b-table>
  </div>
</template>

<script>
// src\data> index.js
import data from "@/data";

let items = data.Board.sort((a, b) => {
  // 내림차순 정렬
  return b.article_no - a.article_no;
});

items = data.Board.map((boardItem) => {
  return {
    ...boardItem,
    name: data.User.filter((userItem) => {
      return userItem.user_id === boardItem.user_id;
    })[0].name,
  };
});

export default {
  name: "BoardList",
  data() {
    return {
      fields: [
        {
          key: "article_no",
          label: "글번호",
        },
        {
          key: "subject",
          label: "제목",
        },
        {
          key: "reg_time",
          label: "작성일",
        },
        {
          key: "name",
          label: "글쓴이",
        },
      ],
      items: items,
    };
  },
};
</script>
