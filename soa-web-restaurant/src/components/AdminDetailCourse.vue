<template lang="">
    <div class="body">

    <div class="row justify-content-center">
    <div class="col-md-6">
      <!-- Update Content -->
      <h1>See Menu In Course</h1>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Menu Id</th>
            <th scope="col">Menu Name</th>
            <th scope="col">Menu Description</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="menu in menus" v-bind:key="menu.menuId">
            <td>{{ menu.menuId }}</td>
            <td>{{ menu.menuName }}</td>
            <td>{{ menu.menuDescription }}</td>
          </tr>
        </tbody>
      </table>
      <router-link to="/addcourse" class="btn btn-secondary">Back to All Courses</router-link>
    </div>
  </div>
</div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            menus: null,
            courseName: null
        }
    },
    created() {
        this.courseName = this.$route.params.name
        axios
            .get(`http://localhost:8080/api/v1/menus/course/${this.courseName}`)
            .then(response => {
                this.menus = response.data;
                console.log(this.menus)
            }).catch(error => {
                console.log(error);
            });
    }
}
</script>

<style scoped>
.body {
    border-radius: 20px;
    background-color: #ffffff;
    padding: 50px;
    box-shadow: 0 4px 8px 0 rgba(199, 199, 199, 0.2), 0 6px 20px 0 rgba(70, 70, 70, 0.19);
}
</style>