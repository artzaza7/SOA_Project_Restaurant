<template>
  <div>
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
          <router-link to="/login" class="nav-link m-1 bg-light btn">Login</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/create" class="nav-link m-1 bg-light btn">Sign up</router-link>
        </li>
       
      </ul>
    </nav>

    <!-- Router View -->
    <div class="container mt-5">
      <router-view></router-view>
    </div>
  </div>
</template>