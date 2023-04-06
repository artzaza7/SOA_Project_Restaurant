<template>
    <!-- <div> -->
    <!-- <ul> -->
    <!-- <li v-for="tables in tabless" :key="tables.tablesId"> -->
    <!-- sfsffds -->
    <!-- {{ tables.tablesId }} - {{ tables.tablesDate }} -->
    <!-- <button @click="editItem(tables)">Edit</button> -->
    <!-- <button @click="deletetables(tables.tablesId)">Delete</button> -->
    <!-- </li> -->
    <!-- </ul> -->
    <!-- </div> -->
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Display List -->
            <!-- <h1 class="row justify-content-center">Show Users</h1> -->
            <!-- <button @click="gettabless">tabless</button> -->
            <table class="table table-hover table-fixed">
                <thead>
                    <tr>
                        <th>Table ID</th>
                        <th>Table Code</th>
                        <th>Amount (Chair)</th>
                        <th>Update</th>
                        <th>Delete</th>
                        <!-- <th>Reservations</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(table, index) in tables" :key="index">
                        <td>{{ table.tableRestaurantId }}</td>
                        <td>{{ table.tableRestaurantCode }}</td>
                        <td>{{ table.tableRestaurantNumberOfChair }}</td>
                        <td><router-link :to="{ name: 'UpdateTablePage', params: { id: table.tableRestaurantId } }"><button
                                    class="btn btn-warning btn-sm">UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteTable(table.tableRestaurantId)"
                                class="btn btn-danger btn-sm">DELETE</button></td>
                        <!-- <td>
                            <ul v-if="table.reservations.length > 0">
                                <li v-for="(reservation, index) in table.reservations" :key="index">
                                    Reservation {{ reservation.reservationId }} on {{ reservation.reservationDate }} from {{
                                        reservation.reservationTimeStart }} to {{ reservation.reservationTimeEnd }} ({{
        reservation.reservationStatus }})
                                </li>
                            </ul>
                            <span v-else>No reservations</span>
                        </td> -->
                    </tr>
                </tbody>
            </table>
            <div class="mt-60">
                <form @submit.prevent="addData">
                    <label for="tableRestaurantCode">Table Restaurant Code:</label>
                    <input type="text" id="tableRestaurantCode" v-model="table.tableRestaurantCode" required>
                    <br>
                    <label for="tableRestaurantNumberOfChair">Number of Chairs:</label>
                    <input type="number" id="tableRestaurantNumberOfChair" v-model="table.tableRestaurantNumberOfChair"
                        required>
                    <br>
                    <button type="submit">Add Data</button>
                </form>
            </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'AdmintablesPage',
    data() {
        return {
            tables: null,
            itemId: null,
            table: {
                tableRestaurantCode: '',
                tableRestaurantNumberOfChair: null,
                reservations: [],
            }
        }
    },
    methods: {
        async getTables() {
            const response = await axios.get('http://localhost:8080/api/v1/tables');
            this.tables = response.data;
            console.log(response.data);
        },

        addData() {
            axios.post("http://localhost:8080/api/v1/tables", this.table)
                .then(
                    ({ data }) => {
                        console.log(data);
                        alert("add success!!!");
                        this.table.tableRestaurantCode = '';
                        this.table.tableRestaurantNumberOfChair = '';
                        this.table.reservations = [];
                        window.location.reload();
                    }
                )
        },
        async deleteTable(id) {
            await axios.delete(`http://localhost:8080/api/v1/tables/${id}`)
            this.getTables();
        }
    },
    created() {
        this.getTables();
    }
}
</script>