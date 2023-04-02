<template>
  <div v-if="!localStorageValue">
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-primary justify-content-between flex-nowrap flex-row">
      <router-link to="/" class="navbar-brand float-left"></router-link>
      <ul class="nav nav-bar flex-row float-right">
        <!-- <li class="nav-item">
          <router-link to="/" class="nav-link m-1 bg-light btn">{{localStorageValue}}</router-link>
        </li> -->
        <li class="nav-item">
          <router-link to="/" class="nav-link m-1 bg-light btn">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/reservation" class="nav-link m-1 bg-light btn">Reservation</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/view" class="nav-link m-1 bg-light btn">view</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link m-1 bg-light btn">Login</router-link>
        </li>
        <!-- <li class="nav-item">
          <router-link to="/sign-up" class="nav-link m-1 bg-light">Sign Up</router-link>
        </li> -->
        <li class="nav-item">
          <router-link to="/sign-up" class="nav-link m-1 bg-light btn">Sign up</router-link>
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
    <nav class="navbar navbar-dark bg-primary justify-content-between flex-nowrap flex-row">
      <router-link to="/" class="navbar-brand float-left"></router-link>
      <ul class="nav nav-bar flex-row float-right">
        <li class="nav-item">
          <router-link to="/" class="nav-link m-1 bg-light btn">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/reservation" class="nav-link m-1 bg-light btn">Reservation</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/view" class="nav-link m-1 bg-light btn">view</router-link>
        </li>

        <li class="nav-item">
          <button @click="logout" class="nav-link m-1 bg-light btn">Logout</button>
        </li>
      </ul>
    </nav>
    <!-- Router View -->
    <div class="container mt-5">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      localStorageValue: localStorage.getItem('user-info')
    }
  },
  methods :{
    logout(){
      localStorage.clear();
      this.$router.push({ name: "LoginPage" })
      window.location.reload();
    }
  }
}
</script>

<style lang="">
    
</style>