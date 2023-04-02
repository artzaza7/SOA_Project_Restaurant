<template lang="">
    <div>
        <h1>Reservation</h1>
        <form @submit.prevent="reservationAction">
        <input type="hidden" v-model="reservation.user">
        <div class="row justify-content-center">
            <div class="col">
                
                <h4 class="mb-3">Select Table</h4>
                <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" v-model="reservation.tableRestaurant" required>
                    <option v-for="table in tables" v-bind:key="table.tableRestaurantId" v-bind:value="table.tableRestaurantId">{{ table.tableRestaurantCode }} Have {{table.tableRestaurantNumberOfChair}} Chair(s)</option>
                </select>

                
                <h4 class="mb-3">Select Course Menu</h4>
                <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" v-model="reservation.courseMenu" required>
                    <option v-for="courseMenu in courseMenus" v-bind:key="courseMenu.courseMenuId" v-bind:value="courseMenu.courseMenuId">{{ courseMenu.courseMenuName }}</option>
                </select>


                <h4 class="mb-3">Select Date</h4>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Date</span>
                    <input type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" v-model="reservation.reservationDate" required>
                </div>

                <h4 class="mb-3">Select Time Start</h4>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Time Start</span>
                    <input type="time" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" v-model="reservation.reservationTimeStart" required>
                </div>
                <h4 class="mb-3">Select Time End</h4>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Time End</span>
                    <input type="time" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" v-model="reservation.reservationTimeEnd" required>
                </div>
                <button type="submit" class="btn btn-success">BOOKING</button>

            </div>
        </div>

        </form>
    </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';

export default {
    data() {
        return {
            tables: null,
            courseMenus: null,
            reservation: {
                user: "",
                courseMenu: "",
                tableRestaurant: "",
                reservationDate: "",
                reservationTimeStart: "",
                reservationTimeEnd: "",
            },
        }
    },
    methods: {
        async reservationAction() {
            const convertDate  = moment(this.reservation.reservationDate).format('YYYY-MM-DD');
            this.reservation.reservationDate = convertDate;

            const timeStart = moment(this.reservation.reservationTimeStart, 'HH:mm').format('HH:mm:ss');
            this.reservation.reservationTimeStart = timeStart;

            const timeEnd = moment(this.reservation.reservationTimeEnd, 'HH:mm').format('HH:mm:ss');
            this.reservation.reservationTimeEnd = timeEnd;

            console.log( this.reservation.reservationDate );
            console.log( this.reservation.reservationTimeStart );
            console.log( this.reservation.reservationTimeEnd );
            console.log(this.reservation);
            await axios.post("http://localhost:8080/api/v1/reservations/", JSON.stringify(this.reservation), { headers: { "Content-Type": "application/json" } })
                .then(
                    ({ data }) => {
                        // alert("saved success!!!");
                        this.reservation.user = '';
                        this.reservation.courseMenu = '';
                        this.reservation.tableRestaurant = '',
                        this.reservation.reservationDate = '',
                        this.reservation.reservationTimeStart = '',
                        this.reservation.reservationTimeEnd = '',
                        alert("Booking success!");
                        console.log(data);
                    }
                );
        }
    },
    created() {
        axios
            .get('http://localhost:8080/api/v1/tables')
            .then(response => {
                this.tables = response.data;
            }).catch(error => {
                console.log(error);
            });

        axios
            .get('http://localhost:8080/api/v1/coursemenus')
            .then(response => {
                this.courseMenus = response.data;
            }).catch(error => {
                console.log(error);
            });

        const userId = JSON.parse(localStorage.getItem('user-info')).userId;
        if (userId) {
            this.reservation.user = userId;
        }
    }

}
</script>

<style lang="">
    
</style>