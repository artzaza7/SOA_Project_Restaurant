<template>
    <div class="row jsutify-content-center">
        <div class="col-md-6">
            <!-- Update Content -->
            <h1>See Table</h1>
            <table class="table table-hover table-dark">
        <thead>
          <tr>
            <th scope="col">Table_Code</th>
            <th scope="col">Last</th>
            <th scope="col">NumOfChair</th>
          
          </tr>
        </thead>
        <tbody>
          <tr v-for="tables in table" v-bind:key="tables.tableRestaurantId">
            <td>{{ tables.tableRestaurantCode }}</td>
            <td>{{ tables.tableRestaurantCode }}</td>
            <td>{{ tables.tableRestaurantNumberOfChair }}</td>
            
          </tr>
        </tbody>
      </table>
        </div>
    </div>
</template>


<script>
import axios from "axios";
export default {
    name: 'UnknowSeeTablePage',
    data() {
    return {
      table: this.table,
    };
  },
  mounted() {
    axios.get("http://localhost:8081/api/v1/tables").then((response) => {
        this.table = response.data;
        console.log(response.data);
      });
  },
}
</script>