
<template>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="mt-60">
                <form @submit.prevent="updateTable">
                    <label for="tableRestaurantCode">Table Restaurant Code:</label>
                    <input type="text" id="tableRestaurantCode" v-model="table.tableRestaurantCode" required>
                    <br>
                    <label for="tableRestaurantNumberOfChair">Number of Chairs:</label>
                    <input type="number" id="tableRestaurantNumberOfChair" v-model="table.tableRestaurantNumberOfChair"
                        required>
                    <br>
                    <button type="submit">Update Data</button>
                </form>
            </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'UpdateTablePage',
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
            const response = await axios.get(`http://localhost:8080/api/v1/tables/${this.$route.params.id}`);
            this.tables = response.data;
            console.log(response.data);
        },
        async updateTable() {
            const response = await axios.put(`http://localhost:8080/api/v1/tables/${this.$route.params.id}`, this.table);
            console.log(response.data);
            this.$router.push('/addtable')
        },
    },
    created() {
        this.getTables();
    }
}
</script>