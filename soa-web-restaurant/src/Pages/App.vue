<!-- <style>
/* .navbar {
  font-family: Georgia, "Times New Roman", Times, serif;
} */
</style> -->

<template>
  <div v-if="!localStorageValue">
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark justify-content-between flex-nowrap flex-row font1">
      <router-link to="/" class="navbar-brand float-left"></router-link>
      <ul class="nav nav-bar flex-row float-right text-dark">
        <!-- <li class="nav-item">
          <router-link to="/" class="nav-link m-1 bg-light btn">{{localStorageValue}}</router-link>
        </li> -->
        <li class="nav-item text-dark">
          <router-link to="/homepage" class="nav-link m-1 bg-light btn text-dark">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Table" class="nav-link m-1 bg-light btn text-dark">Table</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Course" class="nav-link m-1 bg-light btn text-dark">Course</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Menu" class="nav-link m-1 bg-light btn text-dark">Menu</router-link>
        </li>
        <!-- <li class="nav-item">
          <router-link to="/view" class="nav-link m-1 bg-light btn text-dark">view</router-link>
        </li> -->
        <li class="nav-item">
          <router-link to="/login" class="nav-link m-1 bg-light btn text-dark">Login</router-link>
        </li>
        <!-- <li class="nav-item">
          <router-link to="/sign-up" class="nav-link m-1 bg-light">Sign Up</router-link>
        </li> -->
        <li class="nav-item">
          <router-link to="/sign-up" class="nav-link m-1 bg-light btn text-dark">Sign up</router-link>
        </li>

      </ul>
    </nav>
    <!-- Router View -->
    <div class="container mt-5">
      <router-view></router-view>
    </div>
  </div>

  <div v-else>
    <!-- Navbar -->
    <div v-if="user.userType == 'ADMIN' || user.userType == 'admin'">
      <nav class="navbar navbar-dark bg-dark justify-content-between flex-nowrap flex-row">
        <router-link to="/" class="navbar-brand float-left"></router-link>
        <ul class="nav nav-bar flex-row float-right mr-auto">
          <!-- <li class="nav-item">
            <router-link to="/" class="nav-link m-1 bg-light btn">{{ user.userType
            }}</router-link>
          </li> -->
          <li class="nav-item">
            <router-link to="/allreservation" class="nav-link m-1 bg-light btn text-dark">Reservation</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/allusers" class="nav-link m-1 bg-light btn text-dark">All Users</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/addcourse" class="nav-link m-1 bg-light btn text-dark">Add Courses</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/addmenu" class="nav-link m-1 bg-light btn text-dark">Add Menu</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/addtable" class="nav-link m-1 bg-light btn text-dark">Add Table</router-link>
          </li>
          <li class="nav-item">
            <button @click="logout" class="nav-link m-1 bg-light btn text-dark">Logout</button>
          </li>
        </ul>
      </nav>
      <!-- Router View -->
      <div class="container mt-5">
        <router-view></router-view>
      </div>
    </div>
    <div v-else>
      <nav class="navbar navbar-dark bg-dark justify-content-between flex-nowrap flex-row">
        <router-link to="/" class="navbar-brand float-left"></router-link>
        <ul class="nav nav-bar flex-row float-right">
          <li class="nav-item">
            <router-link to="/" class="nav-link m-1 bg-light btn text-dark">{{ user.userType
            }}</router-link>
          </li>
          <!-- <li class="nav-item">
            <router-link to="/" class="nav-link m-1 bg-light btn">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/reservation" class="nav-link m-1 bg-light btn">Reservation</router-link>
          </li> -->

          <li class="nav-item">
            <router-link to="/userReservation" class="nav-link m-1 bg-light btn text-dark">Reservation</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/userHistoryReservation" class="nav-link m-1 bg-light btn text-dark">History Reservation</router-link>
          </li>
          
          <!-- <li class="nav-item">
            <router-link to="/view" class="nav-link m-1 bg-light btn text-dark">view</router-link>
          </li> -->

          <li class="nav-item">
            <button @click="logout" class="nav-link m-1 bg-light btn text-dark">Logout</button>
          </li>
        </ul>
      </nav>
      <!-- Router View -->
      <div class="container mt-5">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import router from '@/router';


export default {
  data() {
    return {
      localStorageValue: localStorage.getItem('user-info'),
      user: JSON.parse(localStorage.getItem('user-info')),
    }
  },
  methods: {
    logout() {
      localStorage.clear();
      // this.$router.push({ name: "LoginPage" })
      const resolvedRoute = router.resolve({ name: "LoginPage" })
      window.location.href = resolvedRoute.href;
    },
  }
}
</script>

<style lang="">
    
</style>