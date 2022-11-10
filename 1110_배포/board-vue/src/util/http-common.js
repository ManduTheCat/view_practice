import axios from "axios";

// 애는 주소 까지만 만들거다
// 공식문서 보시오
export default axios.create({
  baseURL: "http://localhost:9999/vue/",
  headers: {
    // 여기다 토큰 정보 넘기는것도 가능
    "Content-Type": "application/json",
  },
});
