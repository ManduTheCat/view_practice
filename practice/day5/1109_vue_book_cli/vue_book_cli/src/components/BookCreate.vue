<template>
  <div class="regist">
    <h1 class="underline">SSAFY 도서 등록</h1>
    <div class="regist_form">
      <label for="isbn">도서번호</label>
      <input type="text" id="isbn" name="isbn" v-model="isbn" /><br />
      <label for="title">도서명</label>
      <input type="text" id="title" name="title" v-model="title" /><br />
      <label for="author">저자</label>
      <input type="text" id="author" name="author" v-model="author" /><br />
      <label for="price">가격</label>
      <input type="number" id="price" name="price" v-model="price" /><br />
      <label for="content">설명</label>
      <br />
      <textarea id="content" name="content" cols="35" rows="5" v-model="content"></textarea><br />
      <button @click="checkValue">등록</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isbn: "",
      title: "",
      author: "",
      price: "",
      content: "",
    };
  },
  methods: {
    moveList() {
      this.$emit("moveList", true);
    },
    checkValue() {
      //사용자 입력값 체크
      if (
        this.isbn == "" ||
        this.title == "" ||
        this.author == "" ||
        this.price == "" ||
        this.content == ""
      )
        alert("내용을 모두 입력하세요.");
      else this.registBook();
    },
    registBook() {
      const booklist = localStorage.getItem("booklist");

      let newBook = {
        books: [],
      };

      if (booklist) {
        newBook = JSON.parse(booklist);
      }
      //화면에 입력된 데이터를 newBook에 추가
      newBook.books.push({
        isbn: this.isbn,
        title: this.title,
        author: this.author,
        price: this.price,
        content: this.content,
      });

      //로컬스토리지 저장
      localStorage.setItem("booklist", JSON.stringify(newBook));

      alert("등록 완료!");
      
      // 등록후에 부모에게 이벤트 보냄: 등록 완료했으니 목록 보여주세요!!!
      this.$emit("moveList", true);
    },
  },
};
</script>

<style></style>
