import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

new Vue({
  router, //라우터 등록
  store,
  render: (h) => h(App),
}).$mount("#app");
