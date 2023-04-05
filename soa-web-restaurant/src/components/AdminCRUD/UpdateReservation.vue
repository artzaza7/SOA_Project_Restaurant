<template>
    <div>
        <h2>Update Reservation ID: {{ $route.params.id }}</h2>
        <form>
            <!-- <label>Status:</label> -->
            <!-- <input type="text" v-model="reservation.reservationStatus"> -->
            <div>
                <label for="status">Status:</label>
                <select name="status" id="status" v-model="selected">
                    <option v-for="s in status" :key="s.id" :value="s.name">{{ s.name }}</option>
                </select>
            </div>
            <p>You selected: {{ selected }}</p>
            <button @click.prevent="updateReservation">Update</button>
        </form>
    </div>
</template>
      
<script>
import axios from 'axios'

export default {
    data() {
        return {
            reservation: null,
            selected: '',
            status: [
                { id: 1, name: 'BOOKING' },
                { id: 2, name: 'CANCEL' },
            ]
        }
    },
    created() {
        this.getReservation();
    },
    methods: {
        async getReservation() {
            const response = await axios.get(`http://localhost:8080/api/v1/reservations/${this.$route.params.id}`)
            this.reservation = response.data;
            // console.log("this GET ======= " + this.reservation);
        },
        async updateReservation() {
            console.log("this.reservation PUT ==== " + JSON.stringify(this.reservation));
            this.reservation.reservationStatus = this.selected;
            // console.log("this.reservation.reservationStatus ==== " + JSON.stringify(this.reservation.reservationStatus));
            console.log("this.reservation.reservationStatus ==== " + JSON.stringify(this.reservation));
            await axios.put(`http://localhost:8080/api/v1/reservations/${this.$route.params.id}`, this.reservation)
            this.$router.push('/allreservation')
        }
    },
}
</script>
    