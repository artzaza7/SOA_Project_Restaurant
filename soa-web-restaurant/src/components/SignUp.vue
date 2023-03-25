<template>
    <div class="row justify-content-center">
        <div class="col-md-5">
            <!-- Content goes here -->
            <h1 class="row justify-content-center">Sign Up</h1>
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
                <div class="form-group row justify-content-center m-3">
                    <button type="submit" class="btn btn-primary">Sign up</button>
                    <p>
                    <router-link to="/login" class="form-group row justify-content-center m-3">Login</router-link>
                </p>
                </div>
            </form>
            <!-- <h3>{{ user }}</h3> -->
        </div>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    name: "SignUpPage",
    props: {
        msg: String
    },
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
        async saveData() {
            await axios.post("http://localhost:8080/api/v1/users/", this.user)
                .then(
                    ({ data }) => {
                        // alert("saved success!!!");
                        this.user.userUsername = '';
                        this.userPassword = '';
                        this.user.userFirstname = '',
                            this.userLastname = '',
                            this.userPhonenumber = '',
                            alert("Sign up success!");
                        localStorage.setItem("user-info", JSON.stringify(data));
                        this.$router.push({ name: "HomePage" })
                        console.log(data);
                    }
                );
        },

        mounted() {
            let user = localStorage.getItem('user-info');
            if(user) {
                this.$router.push({ name: "HomePage" })
            }
        }
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