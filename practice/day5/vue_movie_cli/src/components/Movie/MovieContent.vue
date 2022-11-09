<template>
  <div class="container">
    <div class="text-center">
      <img :src="imageSrc" alt="" />
      <h1>{{ message }}</h1>
    </div>
    <br />
  </div>
</template>
<script>
export default {
  data() {
    return {
      message: "영화 정보 관리 사이트 입니다.",
      imageSrc: "./img/ssafy_logo.png",
    };
  },
};
</script>
