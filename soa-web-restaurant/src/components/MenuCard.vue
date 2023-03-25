<script>
import axios from 'axios';
export default {
  name: "HelloWorld",
  props: {
    msg: null
  },
  data() {
        return {
            info: null,
            table:null,
            course:null
        }
    },
    mounted() {
        axios
            .get('http://localhost:8081/api/v1/users')
            .then(response => {(this.info = response.data);
            console.log(response.data)}),

          axios
            .get('http://localhost:8081/api/v1/tables')
            .then(response => {(this.table = response.data);
            console.log(response.data)})

            axios
            .get('http://localhost:8081/api/v1/coursemenus')
            .then(response => {(this.course = response.data);
            console.log(response.data)})
            
    }
};


</script>

<template>
  <div class="card" style="width: 100%" >

<div id="demo" class="carousel slide" data-bs-ride="carousel">
<!-- Indicators/dots -->
<div class="carousel-indicators">
  <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
  <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
  <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
</div>

<!-- The slideshow/carousel -->
<div class="carousel-inner">
  <div class="carousel-item active">
    <img src="https://cdn.eatigo.com/filters:format(webp)/eatigo_dd7b5b79948e4b32ca3c9cae4aee43ec_20180103122415_1920.jpg" alt="New York" class="d-block w-100">
  </div>
 
</div>
<!-- Left and right controls/icons -->
<button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
  <span class="carousel-control-prev-icon"></span>
</button>
<button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
  <span class="carousel-control-next-icon"></span>
</button>
</div>

    <div class="card-body" >
      <div class="row">
        <div class="col">
          <h5 class="card-title">
            <!-- {{ coursemenu.courseMenuName }} -->
          </h5>
          <p class="card-text">Steak</p>
        </div>
        <div class="col-4">
          <router-link to="/reservation" class="btn btn-warning"
            >จอง</router-link>
        </div>
        <div class="dropdown">
  <button class="btn btn-outline-danger dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    ดูเมนูทั้งหมด
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="#">Action</a></li>
    <li><a class="dropdown-item" href="#">Another action</a></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
  </ul>
</div>
      </div>
    </div>
  </div>
  
</template>

