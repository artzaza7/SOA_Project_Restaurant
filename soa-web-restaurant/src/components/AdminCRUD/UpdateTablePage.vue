
<template>
    <div class="body">
        <div class="">

            <form @submit.prevent="updateTable">
                <div class="row justify-content-center">
                    <div class="col-md-4">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Table Restaurant Code</span>
                        <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                            id="tableRestaurantCode" v-model="table.tableRestaurantCode" required>

                        <span class="input-group-text" id="inputGroup-sizing-sm">Number of Chairs</span>
                        <input type="number" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                            id="tableRestaurantNumberOfChair" v-model="table.tableRestaurantNumberOfChair" required>

                        <div class="row justify-content-center">
                            <div class="col-md-3 row">
                                <router-link to="/addtable"><button type="button"
                                        class="btn btn-light mt-3">Cancel</button></router-link>
                            </div>
                            <div class="col-md-3 ml-4">
                                <button type="submit" class="btn btn-success btn-md mt-3">Update</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </div>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'UpdateTablePage',
    data() {
        return {
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
            this.table = response.data;
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

<style scoped>
.body {
    border-radius: 20px;
    background-color: #ffffff;
    padding: 50px;
    box-shadow: 0 4px 8px 0 rgba(199, 199, 199, 0.2), 0 6px 20px 0 rgba(70, 70, 70, 0.19);
}
</style>