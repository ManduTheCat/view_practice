import Vue from "vue";
import VueRouter from "vue-router";

import AppMain from "@/views/AppMain";
import AppUser from "@/views/AppUser";

Vue.use(VueRouter);
//임포트를 하면 하번에 다 읽어드린다
// lazy 로디을 하면 나중에 로딩을 한다
// component: () => import("@/views/AppBoard"),
//적절하게 맞춰쓰면됨다
const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/user",
    name: "user",
    component: AppUser,
  },
  {
    path: "/board",
    name: "board",

    component: () => import("@/views/AppBoard"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
