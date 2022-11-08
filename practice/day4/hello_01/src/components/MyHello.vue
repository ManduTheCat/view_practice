<template>
  <div class="my-hello">
    <h1>{{ msg }}</h1>
  </div>
</template>
<script>
export default {
  el: ".my-hello",
  name: "MyHello",
  props: {
    msg: String,
  },
};
</script>
