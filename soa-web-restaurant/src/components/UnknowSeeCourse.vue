<template>
  <div class="row justify-content-center">
    <div class="col-md-6">
      <!-- Update Content -->
      <h1>See Course</h1>
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">Menu_Id</th>
            <th scope="col">Last</th>
            <th scope="col">View Menu</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="course in course" v-bind:key="course.course_menu_id">
            <td>{{ course.courseMenuId }}</td>
            <td>{{ course.courseMenuName }}</td>
            <td>
              <!-- <button type="button" class="btn btn-success">View Menu</button> -->
              <router-link :to="{ name: 'UnknowSeeMenuInCourse', params: { name: course.courseMenuName } }" class="btn btn-success">Detail Course</router-link>
            </td>
            
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UnknowSeeCoursePage",
  data() {
    return {
      course: this.course,
    };
  },
  mounted() {
    axios.get("http://localhost:8080/api/v1/coursemenus").then((response) => {
      this.course = response.data;
      console.log(response.data);
    });
  },
};
</script>
