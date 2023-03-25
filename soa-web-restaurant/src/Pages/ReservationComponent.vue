<template>
  <div class="row justify-content-center" v-for="user in info" v-bind:key="user.userId">
    
    <div class="col"></div>
    <div class="col">
      <h4 class="mb-3">Reservation_id : {{ user.userId }}</h4>
    <h4 class="mb-3">User_Name : {{ user.userFirstname }} {{ user.userLastname }}</h4>
      <h4 class="mb-3">Select Table</h4>
      <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">

        <!-- <option selected>Select Table</option> -->
        <option value="1" v-for="table in table" v-bind:key="table.tableRestaurantId">{{ table.tableRestaurantCode }}</option>
      </select>
      <h4>Select Course</h4>
      <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
        <!-- <option selected>Select Course</option> -->
        <option value="1" v-for="coursemenu in course" v-bind:key="coursemenu.courseMenuId">{{ coursemenu.courseMenuName
 }}</option>
        
      </select>
      <div class="row justify-content-between">
        <div class="col-4 ">
        <button type="submit" class="btn btn-success">Save</button>
      </div><div class="col-4">
        <button type="button" class="btn btn-danger">Cancle</button>
      </div>
      </div>
    </div>
    <div class="col"></div>
  </div>
  
</template>

<script>
import axios from 'axios';
export default {
  
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
   
}
</script>