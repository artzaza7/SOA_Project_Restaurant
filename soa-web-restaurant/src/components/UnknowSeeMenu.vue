<template>
    <div class="row jsutify-content-center">
        <div class="col-md-6">
            <!-- Update Content -->
            <h1>See Menu</h1>
            <table class="table table-hover table-dark">
        <thead>
          <tr>
            <th scope="col">Menu</th>
            <th scope="col">Description</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="menus in  menu" v-bind:key="menus.menuId">
            <td>{{ menus.menuName}}</td>
            <td>{{ menus.menuDescription }}</td>
          </tr>
        </tbody>
      </table>
        </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
    name: 'UnknowSeeMenuPage',
    data() {
    return {
      menu: this.menu,
    };
  },
  mounted() {
    axios
        .get("http://localhost:8080/api/v1/menus")
        .then((response) => {
          this.menu = response.data;
          console.log(response.data);
        });
  },
}
</script>