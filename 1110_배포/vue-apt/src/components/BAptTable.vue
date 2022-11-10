<template>
  <div>
    <b-table hover :items="apt"></b-table>
  </div>
</template>

<script>
export default {
  props: {
    apt: Array,
  },
  data() {
    return {
      fields: [],
      items: [],
    };
  },
  created() {
    console.log("apt" + this.apt);
    console.log("keys" + Object.keys(this.apt));
  },
};
</script>

<style lang="scss" scoped></style>
