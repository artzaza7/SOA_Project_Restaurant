<template>
    <div class="row justify-content-center">
        <div class="col-md-5">
            <!-- Content goes here -->
            <h1 class="row justify-content-center">Create User</h1>
            <form @submit.prevent="saveData">
                <div class="form-group">
                    <label for="text">First Name</label>
                    <input type="text" class="form-control" v-model="user.userFirstname" required>
                </div>
                <div class="form-group">
                    <label for="text">Last Name</label>
                    <input type="text" class="form-control" v-model="user.userLastname" required>
                </div>
                <div class="form-group">
                    <label for="text">Phone</label>
                    <input type="text" class="form-control" v-model="user.userPhonenumber" required>
                </div>
                <div class="form-group">
                    <label for="text">Username</label>
                    <input type="text" class="form-control" v-model="user.userUsername" required>
                </div>
                <div class="form-group">
                    <label for="text">Password</label>
                    <input type="text" class="form-control" v-model="user.userPassword" required>
                </div>
                <div class="form-group row justify-content-center m-2">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
            <h3>{{ user }}</h3>
        </div>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data() {
        return {
            user: {
                userUsername: "",
                userPassword: "",
                userFirstname: "",
                userLastname: "",
                userPhonenumber: ""
            }
        }
    },
    methods: {
        saveData() {
            axios.post("http://localhost:8081/api/v1/users/", this.user)
                .then(
                    ({ data }) => {
                        console.log(data);
                        alert("saved success!!!");
                        this.user.userUsername = '';
                        this.userPassword = '';
                        this.user.userFirstname = '',
                        this.userLastname = '',
                        this.userPhonenumber = ''
                    }
                )
        },
        // handleSubmitForm() {
        //     let apiURL = 'http://localhost:8080/api/v1/users/';

        //     axios.post(apiURL, this.user).then((e) => {
        //         console.log(e.data);
        //         this.$router.push('/view');
        //         this.user = {
        //             userUsername: this.user.userUsername,
        //             userPassword: this.userPassword,
        //             userFirstname: this.user.userFirstname,
        //             userLastname: this.userLastname,
        //             userPhonenumber: this.userPhonenumber
        //         }
        //     }).catch(error => {
        //         console.log(error);
        //     })
        // }
    }
}
</script>