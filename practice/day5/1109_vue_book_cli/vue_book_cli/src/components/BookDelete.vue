<template>
  <div>
    <h1>SSAFY 도서 삭제</h1>
    <div>삭제중...</div>
  </div>
</template>

<script>
export default {
  props: {
    isbn: {
      type: String,
    },
  },
  mounted() {
    // const params = new URL(document.location).searchParams;

    // TODO:
    // 로컬스토리지 저장소에서 도서목록 가져오기
    // 도서목록 배열을 순차적 반복하면서 삭제도서가 아닌도서들만 배열요소로 새로운 배열 생성
    // 참고: Array.filter(callback(element, index, array), thisArg)
    // 로컬스토리지 저장소에 도서목록 저장하기
    // 삭제 완료후 부모에게 이벤트 보내기: 삭제 완료했으니 도서목록 보여주세요!!!
    const booklist = JSON.parse(localStorage.getItem("booklist"));
    booklist.books = booklist.books.filter((book) => {
      return book.isbn != this.isbn;
    });
    // 도서목록 booklist객체를 booklist라는 이름으로 localStorage에 저장한다.
    localStorage.setItem("booklist", JSON.stringify(booklist));
    this.movePage();
  },
  methods: {
    movePage() {
      alert("삭제가 완료되었습니다.");
      this.$emit("moveList", true);
    },
  },
};
</script>

<style></style>
