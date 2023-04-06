<!-- <style>
/* .row{
    font-family: Georgia, "Times New Roman", Times, serif;
} */
</style> -->
<template>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Display List -->
            <h1 class="row justify-content-center">Show Users</h1>
            <table class="table table-striped">
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