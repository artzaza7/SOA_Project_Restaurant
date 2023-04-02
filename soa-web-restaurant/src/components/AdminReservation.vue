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
    <!-- </div> -->
    <div class="row jsutify-content-center">
        <div class="col-md-4">
            <!-- Display List -->
            <!-- <h1 class="row justify-content-center">Show Users</h1> -->
            <!-- <button @click="getReservations">Reservations</button> -->
            <table class="table table-striped">
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
                                :to="{ name: 'UpdateReservationPage', params: { id: reservation.reservationId } }"><button>UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteReservation(reservation.reservationId)">DELETE</button></td>
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