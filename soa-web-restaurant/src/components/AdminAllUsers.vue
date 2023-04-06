<template>
    <div class="body">
        <div class="">
            <!-- Display List -->
            <!-- <h1 class="row justify-content-center mb-5">All Users</h1> -->
            <table class="table table-hover table-fixed">
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone</th>
                </thead>
                <tbody>
                    <tr v-for="user in info" v-bind:key="user.userId">
                        <td>{{ user.userFirstname }}</td>
                        <td>{{ user.userLastname }}</td>
                        <td>{{ user.userPhonenumber }}</td>
                    </tr>
                </tbody>
                <!-- <h3>{{ info }}</h3> -->
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            info: null
        }
    },
    mounted() {
        axios
            .get('http://localhost:8080/api/v1/users')
            .then(response => {
                (this.info = response.data);
                console.log(response.data)
            })

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