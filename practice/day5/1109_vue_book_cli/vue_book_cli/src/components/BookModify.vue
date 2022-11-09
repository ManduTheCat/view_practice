<template>
  <div class="regist">
    <h1 class="underline">SSAFY 도서 수정</h1>
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
      <button @click="checkValue">수정</button>
      <button @click="movePage">목록</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    modiIsbn: {
      type: String,
    },
  },
  data() {
    return {
      isbn: "",
      title: "",
      author: "",
      price: "",
      content: "",
    };
  },
  created() {
    // const params = new URL(document.location).searchParams;

    const booklist = JSON.parse(localStorage.getItem("booklist"));
    for (let obj of booklist.books) {
      if (this.modiIsbn == obj.isbn) {
        this.isbn = obj.isbn;
        this.title = obj.title;
        this.author = obj.author;
        this.price = obj.price;
        this.content = obj.content;
        break;
      }
    }
  },
  methods: {
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
      else this.modifyBook();
    },
    modifyBook() {
      // const params = new URL(document.location).searchParams;

      // TODO: 
      // 로컬스토리지 저장소 도서정보 가져오기
      // 동일한 도서번호 객체 검색해서 기존 도서 정보 변경하기
      // 변경한 도서정보로 로컬스토리지 저장소 변경하기
      // 수정후 상위뷰(HomeView.vue) 에게 이벤트 보내기 : 도서변경완료했으니 도서목록 보여주세요!! 요청의뢰!!
      // const booklist = JSON.parse(localStorage.getItem("booklist"));

    },
    movePage() {
      this.$emit("moveList", true);
    },
  },
};
</script>

<style></style>
