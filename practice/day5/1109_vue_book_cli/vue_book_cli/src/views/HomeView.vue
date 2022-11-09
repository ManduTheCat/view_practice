<template>
  <div class="home">
    <header-nav></header-nav>
    <!-- <book-list></book-list> -->
    <!-- 3. 컴포넌트 보여주기: 조건에 따라 컴포넌트 제어 -->
    <!-- 목록 -->
    <div v-if="this.listView">
      <book-list @changeCreate="listToCre" @changeView="changeView"></book-list>
    </div>

    <!-- 등록 -->
    <div v-if="this.createView">
      <!-- 등록 후 하위뷰 이벤트 받아서 처리(목록조회): this.$emit("moveList", true); -->
      <book-create v-on:moveList="moveTolist"></book-create>
    </div>

    <!-- 변경(조회) -->
    <div v-if="this.modiView">
      <book-modify @moveList="moveTolist" :modiIsbn="isbn"></book-modify>
    </div>

    <!-- 상세조회 -->
    <div v-if="this.detailView">
      <book-view
        :isbn="isbn"
        @moveList="moveTolist"
        @moveToModi="moveToModi"
        @deleteBook="deleteBook"
      ></book-view>
    </div>

    <!-- 삭제 -->
    <div v-if="this.deleteVeiw">
      <book-delete :isbn="isbn" @moveList="moveTolist"></book-delete>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from "@/components/HelloWorld.vue";
//TODO : 1. 여기에 모든 컴포넌트 가져오기
import HeaderNav from "@/components/common/HeaderNav.vue";
import BookList from "@/components/BookList.vue";
import BookCreate from "@/components/BookCreate.vue";


export default {
  name: "HomeView",
  //TODO: 2. 여기에 모든 컴포넌트 등록하기
  components: {
    HeaderNav,
    BookList,
    BookCreate,
  },
  data() {
    return {
      // HomeView에서 조건에 따라 화면 제어 
      listView: true,
      createView: false,
      modiView: false,
      detailView: false,
      deleteVeiw: false,
      isbn: "",
    };
  },
  methods: {
    listToCre(tri) { // 등록 제어
      this.listView = false;
      this.createView = tri;
    },
    changeView(isbn) { // 상세조회 제어
      this.listView = false;
      this.isbn = isbn;
      this.detailView = true;
    },
    moveTolist(tri) { // 목록 제어
      this.listView = tri;
      this.modiView = false;
      this.createView = false;
      this.detailView = false;
      this.deleteVeiw = false;
    },
    moveToModi(isbn) { // 변경 제어
      this.detailView = false;
      this.isbn = isbn;
      this.modiView = true;
    },
    deleteBook(isbn) { // 삭제 제어
      this.detailView = false;
      this.isbn = isbn;
      this.deleteVeiw = true;
    },
  },
};
</script>

<style>
/* 전역 css 설정하기 */
a {
  text-decoration: none;
  color: #787878;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
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
button,
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
.regist {
  padding: 10px;
}
.regist_form {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
.ssafy_logo {
  width: 150px;
}
.header {
  text-align: center;
  box-shadow: 0px 1px 10px rgba(0, 0, 0, 0.3);
}
.header img {
  vertical-align: middle;
}
.logo {
  display: inline-block;
  font-size: 30pt;
  font-weight: bold;
}
.underline {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, cyan 30%);
}
#book-list {
  border-collapse: collapse;
  width: 100%;
}

#book-list thead {
  background-color: #ccc;
  font-weight: bold;
}

#book-list td,
#book-list th {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
