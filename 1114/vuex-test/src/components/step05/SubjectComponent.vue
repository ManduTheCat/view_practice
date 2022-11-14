<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
    <button @click="addTenCount">{{ title }} - {{ count }}</button>
    <button @click="addObjCount">{{ title }} - {{ count }}</button>
  </div>
</template>

<script>
import { mapMutations } from "vuex";

export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  // this 로 안가져오고 객체로 가가져오는거 가능
  methods: {
    ...mapMutations({
      addMOne: "ADD_ONE",
      addMTenCount: "ADD_TEN_COUNT",
      addMObjCount: "ADD_OBJ_COUNT",
    }),
    addCount: function () {
      this.count += 1;
      // this.$store.commit('addOne');
      this.addMOne();
    },
    addTenCount: function () {
      this.count += 10;
      // this.$store.commit('addCount', 10);
      this.addMTenCount(10);
    },
    addObjCount: function () {
      let num = Math.round(Math.random() * 100);
      this.count += num;
      // this.$store.commit('addObjCount', { num });
      this.addMObjCount({ num });
    },
  },
};
</script>

<style></style>
