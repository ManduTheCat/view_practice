<template>
  <button @click="addCount">{{ title }} - {{ count }}</button>
</template>

<script>
export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    addCount: function () {
      this.count += 1;
      // 뮤테이션 안써서 데브툴 모른다
      // 부모한테 이제 안보넨다
      // this.$emit("addtotcount");
      // store 로 보넨다 .
      // 아무것도 임포트 안하면 index.js 찾는다
      // 없어도된다.
      this.$store.state.count++;
    },
  },
};
</script>

<style></style>
