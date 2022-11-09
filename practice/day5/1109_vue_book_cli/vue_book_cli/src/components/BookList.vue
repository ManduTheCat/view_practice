<template>
  <div>
    <h1 class="underline">도서 목록</h1>
    <div style="text-align: right">
      <button @click="movePage">도서 등록</button>
    </div>
    <div v-if="books.length">
      <table id="book-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 20%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>ISBN</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(book, index) in books" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ book.isbn }}</td>
            <td>
              <a @click="moveView(book.isbn)">{{ book.title }}</a>
            </td>
            <td>{{ book.author }}</td>
            <td>{{ numberComma(book.price) }}원</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //도서목록을 저장할 배열
      books: [],
    };
  },
  created() {
    //     fetch("http://localhost:9999/book")
    //       .then((res) => res.json())
    //       .then((data) => {
    //         this.books = data;
    //         console.log(this.books);
    //       });

    const booklist = localStorage.getItem("booklist");
    let newBook = {
      books: [],
    };
    if (booklist) {
      //북리스트가 있을때만 넣어줄것.
      newBook = JSON.parse(booklist);
    } else {
      localStorage.setItem("booklist", JSON.stringify(newBook));
    }

    //books변수에 도서목록 저장.
    this.books = newBook.books;
  },
  methods: {
    numberComma(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    movePage() {
      // TODO : 부모에게 요청: 등록페이지 보여주세요
      this.$emit("changeCreate", true);
    },
    moveView(isbn) {
      // TODO : 부모에게 요청: 조회페이지 보여주세요
      this.$emit("changeView", isbn);
    },
  },
};
</script>

<style></style>
