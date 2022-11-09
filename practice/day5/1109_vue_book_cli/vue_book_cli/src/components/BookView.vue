<template>
  <div class="regist">
    <h1 class="underline">SSAFY 도서 정보</h1>
    <!-- TODO : 도서 상세조회 화면 구성하기 -->

    <div class="regist_form">
      <label for="isbn">도서번호</label>
      <input type="text" id="isbn" name="isbn" v-model="returnISbn" /><br />
      <label for="title">도서명</label>
      <div type="text" id="title" name="title">{{ book.title }}</div>
      <br />
      <label for="author">저자</label>
      <div type="text" id="author" name="author">{{ book.author }}</div>
      <br />
      <label for="price">가격</label>
      <div type="number" id="price" name="price">{{ book.price }}</div>
      <br />
      <label for="content">설명</label>
      <br />
      <div id="content" name="content">{{ book.content }}</div>
      <br />
      <button @click="moveToModi(isbn)">수정</button>
      <button @click="movePage(isbn)">목록</button>
      <button @click="removeBook(isbn)">삭제</button>
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
  data() {
    return {
      book: {},
    };
  },
  created() {
    console.log("BookView Created");
    // const params = new URL(document.location).searchParams;
    // TODO : 도서조회페이지가 부착되기 전에 상세조회 도서 정보 가져오기
    const bookData = JSON.parse(localStorage.getItem("booklist"));
    console.log("책을 보여줘 : " + bookData.books);

    const currBook = bookData.books.find((el) => el.isbn === this.isbn);
    console.log(currBook);
    this.book = currBook;
    console.log(this.book);

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
      this.$EventBus.$emit("send", this.isbn);
      this.$emit("moveToModi", isbn);
    },
    removeBook(isbn) {
      this.$emit("deleteBook", isbn);
    },
  },
};
</script>

<style></style>
