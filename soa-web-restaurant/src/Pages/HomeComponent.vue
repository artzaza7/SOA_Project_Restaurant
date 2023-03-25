

<template>
  <div class="row justify-content-between">
    <h3>Course</h3>
    <div
      class="col"
      v-for="coursemenu in course"
      v-bind:key="coursemenu.courseMenuId">
      <!-- CardCourse-->
      <div class="card" style="width: 100%">
        <img
          src="https://cdn.eatigo.com/filters:format(webp)/eatigo_dd7b5b79948e4b32ca3c9cae4aee43ec_20180103122415_1920.jpg"
          alt="New York"
          class="d-block w-100"
        />
        <div class="card-body">
          <div class="row">
            <div class="col">
              <h5 class="card-title">
                {{ coursemenu.courseMenuName }}
              </h5>
              <p class="card-text">Steak</p>
            </div>
            <div class="col-4">
              <router-link to="/reservation" class="btn btn-warning"
                >จอง</router-link
              >
            </div>
            <div class="dropdown">
              <button
                class="btn btn-outline-danger dropdown-toggle"
                type="button"
                id="dropdownMenuButton1"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                ดูเมนูทั้งหมด
              </button>
              <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li>
                  <a
                    class="dropdown-item" href="#" v-for="coursemenulist in menucourse"
                    v-bind:key="coursemenulist.menuInCourses"  >{{ coursemenulist.menuName }}</a
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="row  mt-3">
    <h3>Menu</h3>
    <div class="col">
        <div class="row ">
    <div
      class="col-3 mb-3"
      v-for="menus in menu" v-bind:key="menus.menuId">
      <!-- CardCourse-->
      <div class="card" style="width: 100%">
        <img
          src="https://cdn.eatigo.com/filters:format(webp)/eatigo_dd7b5b79948e4b32ca3c9cae4aee43ec_20180103122415_1920.jpg"
          alt="New York"
          class="d-block w-100"
        />
        <div class="card-body">
          <div class="row">
            <div class="col">
              <h5 class="card-title">
                {{ menus.menuName }}
              </h5>
              <p class="card-text">{{ menus.menuDescription }}</p>
            </div>
            <div class="col-4">
              <router-link to="/reservation" class="btn btn-warning"
                >จอง</router-link
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    </div>
  </div>

  <div class="row justify-content-between mt-3">
    <h3>Type</h3>
    <div class="col">
        <div class="row ">
    <div
      class="col-3 mb-3"
      v-for="menutype in menutype" v-bind:key="menutype.menuTypeId">
      <!-- CardCourse-->
      <div class="card" style="width: 100%">
        <img
          src="https://cdn.eatigo.com/filters:format(webp)/eatigo_dd7b5b79948e4b32ca3c9cae4aee43ec_20180103122415_1920.jpg"
          alt="New York"
          class="d-block w-100"
        />
        <div class="card-body">
          <div class="row">
            <div class="col">
              <h5 class="card-title">
                {{ menutype.menuTypeName }}
              </h5>
              <p class="card-text">...</p>
            </div>
            <div class="col-6">
              <router-link to="#" class="btn btn-warning"
                >ดูเมนูในประเภท</router-link
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      info: null,
      table: null,
      course: this.course,
      menucourse: null,
      menu: null,
      menutype: null
    };
  },
  
  mounted() {
    axios.get("http://localhost:8081/api/v1/users").then((response) => {
      this.info = response.data;
      console.log(response.data);
    }),
      axios.get("http://localhost:8081/api/v1/tables").then((response) => {
        this.table = response.data;
        console.log(response.data);
      }),
      axios.get("http://localhost:8081/api/v1/coursemenus").then((response) => {
        this.course = response.data;
        console.log(response.data);
        
      }),
      axios
        .get("http://localhost:8081/api/v1/menus/course/{name}")
        .then((response) => {
          this.menucourse = response.data;
          console.log(response.data);
        }),
        axios
        .get("http://localhost:8081/api/v1/menus")
        .then((response) => {
          this.menu = response.data;
          console.log(response.data);
        }),
        axios
        .get("http://localhost:8081/api/v1/menuType")
        .then((response) => {
          this.menutype = response.data;
          console.log(response.data);
        });
  },
};
</script>
