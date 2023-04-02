<template>
    <div>
        <h2>Update Reservation ID: {{ $route.params.id }}</h2>
        <form>
            <!-- <label>Status:</label> -->
            <!-- <input type="text" v-model="reservation.reservationStatus"> -->
            <div>
                <label for="status">Status:</label>
                <select name="status" id="status" v-model="reservation.reservationStatus">
                    <option v-bind:value="BOOKING" v-bind:key="BOOKING">BOOKING</option>
                    <option v-bind:value="CANCEL" v-bind:key="CANCEL">CANCEL</option>
                </select>
            </div>
            <button @click.prevent="updateReservation">Update</button>
        </form>
    </div>
</template>
  
<script>
import axios from 'axios'

export default {
    data() {
        return {
            reservation: {
                reservationDate: '',
                reservationStatus: '',
                reservationTimeEnd: '',
                reservationTimeStart: ''
            },
            reservationId: null,
        }
    },
    methods: {
        async getReservation() {
            const response = await axios.get(`http://localhost:8080/api/v1/reservations/${this.$route.params.id}`)
            // console.log("Id ==== " + this.$route.params.id)
            this.reservation = response.data;
            console.log(response.data);
        },
        async updateReservation() {
            console.log("this.reservation ==== " + this.reservation)
            await axios.put(`http://localhost:8080/api/v1/reservations/${this.$route.params.id}`, this.reservation)
            this.$router.push('/allreservation')

            // Show a success message or redirect to a different page
        }
    },
    created() {
        this.reservationId = this.$route.params.reservationId
        this.getReservation()
    }
}
</script>