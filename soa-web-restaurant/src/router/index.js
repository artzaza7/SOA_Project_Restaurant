import { createWebHistory, createRouter } from "vue-router";

//components
import CreateComponent from "@/components/CreateComponent.vue";
import EditComponent from "@/components/EditComponent.vue";
import ListComponent from "@/components/ListComponent.vue";
import HomeComponent from "@/components/HomeComponent.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeComponent,
  },

  {
    path: "/create",
    name: "create",
    component: CreateComponent,
  },
  {
    path: "/edit",
    name: "edit",
    component: EditComponent,
  },
  {
    path: "/view",
    name: "view",
    component: ListComponent,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;