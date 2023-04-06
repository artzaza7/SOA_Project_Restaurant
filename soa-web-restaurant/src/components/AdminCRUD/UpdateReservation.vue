<template>
    <div class="body">
        <!-- <h2>Update Reservation ID: {{ $route.params.id }}</h2> -->
        <form>
            <!-- <label>Status:</label> -->
            <!-- <input type="text" v-model="reservation.reservationStatus"> -->
            <!-- <div>
                <label for="status">Status:</label>
                <select name="status" id="status" v-model="selected">
                    <option v-for="s in status" :key="s.id"value="">{s.name}</option> -->
            <!-- <option v-for="s in status" :key="s.id" :value="s.name">{{ s.name }}</option>
                </select>
            </div>
            <p>You selected: {{ selected }}</p>
            <button @click.prevent="updateReservation">Update</button> -->

            <div class="row justify-content-center">
                <div class="col-md-4">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Update Reservation ID: {{ $route.params.id
                    }}</span>
                    <span class="input-group-text" id="inputGroup-sizing-sm">Status</span>
                    <div class="row justify-content-center">
                        <select class="custom-select" name="status" id="status" v-model="selected">
                            <!-- <option v-for="s in status" :key="s.id"value="">{s.name}</option> -->
                            <option v-for="s in status" :key="s.id" :value="s.name">{{ s.name }}</option>
                        </select>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-md-3 row">
                            <router-link to="/allreservation"><button type="button"
                                    class="btn btn-light mt-3">Cancel</button></router-link>
                        </div>
                        <div class="col-md-3 ml-4">
                            <button type="submit" class="btn btn-success btn-md mt-3"
                                @click.prevent="updateReservation">Update</button>
                        </div>
                    </div>
                </div>
            </div>
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
<style scoped>
.body {
    border-radius: 20px;
    background-color: #ffffff;
    padding: 50px;
    box-shadow: 0 4px 8px 0 rgba(199, 199, 199, 0.2), 0 6px 20px 0 rgba(70, 70, 70, 0.19);
}
</style>
    