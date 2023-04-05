import { createWebHistory, createRouter } from "vue-router";

//components
import SingUp from "@/components/SignUp.vue";
import EditComponent from "@/components/EditComponent.vue";
import ListComponent from "@/components/ListComponent.vue";
import HomePage from "@/Pages/HomePage.vue";
// import ReservationComponent from "@/Pages/ReservationComponent.vue";
import LoginComponent from "@/components/LoginComponent.vue";
// import Home from "@/components/Home.vue";
import CreateComponent from "@/components/CreateComponent.vue";
import UnknowSeeTableVue from "@/components/UnknowSeeTable.vue";
import UnknowSeeMenuVue from "@/components/UnknowSeeMenu.vue";
import UnknowSeeCourseVue from "@/components/UnknowSeeCourse.vue";

//Admin
import AdminReservation from "@/components/AdminReservation.vue";
import AdminAllUsers from "@/components/AdminAllUsers.vue";
import AdminAddCourse from "@/components/AdminAddCourse.vue";
import AdminAddMenu from "@/components/AdminAddMenu.vue";
import AdminAddTable from "@/components/AdminAddTable.vue";

//User
import userReservation from "@/components/UserReservation.vue";
import userHistoryReservation from "@/components/UserHistoryReservation.vue";
import userHistoryReservationDetail from "@/components/userHistoryReservationDetail.vue";
//AdminCRUD
import UpdateReservation from "@/components/AdminCRUD/UpdateReservation.vue";
import UpdateTablePage from "@/components/AdminCRUD/UpdateTablePage.vue";
import UpdateMenuPage from "@/components/AdminCRUD/UpdateMenuPage.vue";
import UpdateCoursePage from "@/components/AdminCRUD/UpdateCoursePage.vue";

const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
  },
  {
    path: "/homepage",
    name: "homepage",
    component: HomePage,
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
  {
    path: "/Table",
    name: "UnknowSeeTablePage",
    component: UnknowSeeTableVue,
  },
  {
    path: "/Course",
    name: "UnknowSeeCoursePage",
    component: UnknowSeeCourseVue,
  },

  {
    path: "/Menu",
    name: "UnknowSeeMenuPage",
    component: UnknowSeeMenuVue,
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

  //User
  {
    path: "/userReservation",
    name: "userReservation",
    component: userReservation,
  },
  {
    path: "/userHistoryReservation",
    name: "userHistoryReservation",
    component: userHistoryReservation,
  },
  {
    path: "/userHistoryReservationDetail/:id",
    name: "userHistoryReservationDetail",
    component: userHistoryReservationDetail,
    params: true,
  },
  //AdminCRUD
  {
    path: "/update/reservation/:id",
    name: "UpdateReservationPage",
    component: UpdateReservation,
  },
  {
    path: "/update/table/:id",
    name: "UpdateTablePage",
    component: UpdateTablePage,
  },
  {
    path: "/update/menu/:id",
    name: "UpdateMenuPage",
    component: UpdateMenuPage,
  },
  {
    path: "/update/course/:id",
    name: "UpdateCoursePage",
    component: UpdateCoursePage,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
