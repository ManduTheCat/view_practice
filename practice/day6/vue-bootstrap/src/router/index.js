import Vue from "vue";
import VueRouter from "vue-router";
import BoaardList from "@/components/BoaardList";
import UserLogin from "@/components/UserLogin";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
  },
  {
    path: "/about",
    name: "about",

    component: () => import("../views/AboutView.vue"),
  },
  {
    path: "/board/list",
    name: "BoaardList",
    component: BoaardList,
  },
  {
    path: "/user/login",
    name: "BoaardList",
    component: UserLogin,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
