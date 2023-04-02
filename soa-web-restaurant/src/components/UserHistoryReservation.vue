<template lang="">
    <div>
        <h1>History table</h1>
        <div class="row justify-content-center">
            <table class="table">
                <thead>
                     <tr>
                        <th scope="col">Reservation ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time Start</th>
                        <th scope="col">Time End</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="reservation in reservations" :key="reservation.reservationId">
                        <td>{{reservation.reservationId}}</td>    
                        <td>{{reservation.reservationDate}}</td>
                        <td>{{reservation.reservationTimeStart}}</td>
                        <td>{{reservation.reservationTimeEnd}}</td>
                        <td>
                            <router-link :to="{ name: 'userHistoryReservationDetail', params: { id: reservation.reservationId } }" class="btn btn-success">History Reservation</router-link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            reservations: null,
            userId: null,
        }
    },
    created() {
        const saveUserId = JSON.parse(localStorage.getItem('user-info')).userId;
        if (saveUserId) {
            this.userId = saveUserId;
            console.log(this.userId);
        }

        axios
            .get(`http://localhost:8080/api/v1/reservations/user/${this.userId}`)
            .then(response => {
                this.reservations = response.data;
                console.log(this.reservations)
            }).catch(error => {
                console.log(error);
            });
    }
}
</script>

<style lang="">
    
</style>