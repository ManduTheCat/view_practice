<template>
  <div id="app">
    <HeaderNavVue> </HeaderNavVue>
    <router-view />
  </div>
</template>

<script>
import HeaderNavVue from "@/components/Movie/HeaderNav.vue";
export default {
  name: "app",
  components: {
    HeaderNavVue,
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
/* 초기화 작업 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none;
  color: #787878;
}

.text-center {
  text-align: center;
}

/* header 태그 안에 CSS 속성 */
header {
  height: 70px;
  background-color: black;
  line-height: 70px;
  padding: 0px 30px;
}

.updateForm {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}

/* content CSS */

.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 80px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px 0;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.movie-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.movie-list td,
.movie-list th {
  border: 1px solid black;
}

.detail-content {
  padding: 10px 30px;
}
</style>
