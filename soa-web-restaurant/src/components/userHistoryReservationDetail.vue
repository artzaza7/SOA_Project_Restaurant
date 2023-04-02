<template lang="">
    <div>
        <h1>History Detail</h1>
        <h1>{{$route.params.id}}</h1>
        <div  class="row justify-content-center">
            <div class="col">
                <table class="table">
                <thead>
                     <tr>
                        <th scope="col">Table Code</th>
                        <th scope="col">Table Number Of Chair(s)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="table in tables" :key="table.tableRestaurantId">
                        <td>{{table.tableRestaurantCode}}</td>    
                        <td>{{table.tableRestaurantNumberOfChair}}</td>
                    </tr>
                </tbody>
                </table>
            </div>
            <div class="col">
                <table class="table">
                <thead>
                     <tr>
                        <th scope="col">Course Menu Name</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="courseMenu in courseMenus" :key="courseMenu.courseMenuId">
                        <td>{{courseMenu.courseMenuName}}</td>    
                    </tr>
                </tbody>
                </table>
            </div>
            <router-link to="/userHistoryReservation" class="btn btn-secondary">Back to All History Reservation</router-link>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            tables: null,
            courseMenus: null,
            reservationId: null
        }
    },
    created() {

        this.reservationId = this.$route.params.id

        axios
            .get(`http://localhost:8080/api/v1/tables/reservation/${this.reservationId}`)
            .then(response => {
                this.tables = response.data;
                console.log(this.tables)
            }).catch(error => {
                console.log(error);
            });

        axios
            .get(`http://localhost:8080/api/v1/coursemenus/reservation/${this.reservationId}`)
            .then(response => {
                this.courseMenus = response.data;
                console.log(this.courseMenus)
            }).catch(error => {
                console.log(error);
            });
    }
}
</script>
<style lang="">
    
</style>