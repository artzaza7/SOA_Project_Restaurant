<template>
    <!-- <div> -->
    <!-- <ul> -->
    <!-- <li v-for="reservation in reservations" :key="reservation.reservationId"> -->
    <!-- sfsffds -->
    <!-- {{ reservation.reservationId }} - {{ reservation.reservationDate }} -->
    <!-- <button @click="editItem(reservation)">Edit</button> -->
    <!-- <button @click="deleteReservation(reservation.reservationId)">Delete</button> -->
    <!-- </li> -->
    <!-- </ul> -->
    <!-- <table> -->


    <div class="body">
        <div class="">
            <!-- Display List -->
            <!-- <h1 class="row justify-content-center">Show Users</h1> -->
            <!-- <button @click="getReservations">Reservations</button> -->
            <table class="table table-hover table-fixed">
                <thead>
                    <th>Id</th>
                    <th>Date</th>
                    <th>Time Start</th>
                    <th>Time End</th>
                    <th>Status</th>
                    <th>Update</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <tr v-for="reservation in reservations" v-bind:key="reservation.reservationId">
                        <td>{{ reservation.reservationId }}</td>
                        <td>{{ reservation.reservationDate }}</td>
                        <td>{{ reservation.reservationTimeStart }}</td>
                        <td>{{ reservation.reservationTimeEnd }}</td>
                        <td>{{ reservation.reservationStatus }}</td>
                        <td><router-link
                                :to="{ name: 'UpdateReservationPage', params: { id: reservation.reservationId } }"><button
                                    class="btn btn-warning btn-sm">UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteReservation(reservation.reservationId)"
                                class="btn btn-danger btn-sm">DELETE</button></td>
                    </tr>
                </tbody>
                <!-- <h3>{{ info }}</h3> -->
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'AdminReservationPage',
    data() {
        return {
            reservations: null,
            itemId: null
        }
    },
    methods: {
        async getReservations() {
            const response = await axios.get('http://localhost:8080/api/v1/reservations');
            this.reservations = response.data;
            console.log(response.data);
        },
        // updateReservation(reservations) {
        //     // implement edit functionality
        // },
        async deleteReservation(reservations) {
            await axios.delete(`http://localhost:8080/api/v1/reservations/${reservations}`)
            this.getReservations();
        }
    },
    created() {
        this.getReservations();
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