import { createWebHistory, createRouter } from "vue-router";

//components
import SingUp from "@/components/SignUp.vue";
import EditComponent from "@/components/EditComponent.vue";
import ListComponent from "@/components/ListComponent.vue";
import HomeComponent from "@/Pages/HomeComponent.vue";
import ReservationComponent from "@/Pages/ReservationComponent.vue";
import LoginComponent from "@/components/LoginComponent.vue";
// import Home from "@/components/Home.vue";
import CreateComponent from "@/components/CreateComponent.vue";

//AfterLogin
import UserAfterLoginComponent from "@/Pages/UserAfterLoginComponent.vue";

import AdminReservation from "@/components/AdminReservation.vue";
import AdminAllUsers from "@/components/AdminAllUsers.vue";
import AdminAddCourse from "@/components/AdminAddCourse.vue";
import AdminAddMenu from "@/components/AdminAddMenu.vue";
import AdminAddTable from "@/components/AdminAddTable.vue";

const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomeComponent,
  },
  {
    path: "/reservation",
    name: "reservation",
    component: ReservationComponent,
  },

  {
    path: "/create",
    name: "create",
    component: CreateComponent,
  },
  {
    path: "/sign-up",
    name: "SignUpPage",
    component: SingUp,
  },
  {
    path: "/login",
    name: "LoginPage",
    component: LoginComponent,
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

  // AfterLogin
  {
    path: "/loginSuccess/:id",
    name: "LoginSuccess",
    component: UserAfterLoginComponent,
    params: true,
  },

  //Admin
  {
    path: "/allreservation",
    name: "AdminReservationPage",
    component: AdminReservation,
  },
  {
    path: "/allusers",
    name: "AdminAllUsersPage",
    component: AdminAllUsers,
  },
  {
    path: "/addcourse",
    name: "AdminAddCoursePage",
    component: AdminAddCourse,
  },
  {
    path: "/addmenu",
    name: "AdminAddMenuPage",
    component: AdminAddMenu,
  },
  {
    path: "/addtable",
    name: "AdminAddTablePage",
    component: AdminAddTable,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
