<template>
  <div class="regist">
    <h1 class="underline">SSAFY 도서 정보</h1>
    <!-- TODO : 도서 상세조회 화면 구성하기 -->

    <div class="regist_form">
      <label for="isbn">도서번호</label>
      <input type="text" id="isbn" name="isbn" v-model="returnISbn" /><br />
      <label for="title">도서명</label>
      <input type="text" id="title" name="title" v-model="title" /><br />
      <label for="author">저자</label>
      <input type="text" id="author" name="author" v-model="author" /><br />
      <label for="price">가격</label>
      <input type="number" id="price" name="price" v-model="price" /><br />
      <label for="content">설명</label>
      <br />
      <textarea id="content" name="content" cols="35" rows="5" v-model="content"></textarea><br />
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isbn: {
      type: String,
    },
  },
  created() {
    // const params = new URL(document.location).searchParams;
    // TODO : 도서조회페이지가 부착되기 전에 상세조회 도서 정보 가져오기
    const book = localStorage.getItem("booklist");
    console.log(book);
    // 로컬스토리지 저장소에서 도서목록 가져오기
    // 도서목록 순차 순회하면서 해당 도서 정보 가져와서 설정하기
  },
  computed: {
    returnISbn() {
      return this.isbn;
    },
  },
  methods: {
    movePage() {
      this.$emit("moveList", true);
    },
    moveToModi(isbn) {
      this.$emit("moveToModi", isbn);
    },
    removeBook(isbn) {
      this.$emit("deleteBook", isbn);
    },
  },
};
</script>

<style></style>
