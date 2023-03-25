<template>
    <div class="row justify-content-center">
        <div class="col-md-5">
            <!-- Content goes here -->
            <h1 class="row justify-content-center">Login</h1>
            <form @submit.prevent="login">
                <div class="form-group">
                    <label for="text">Username</label>
                    <input type="text" class="form-control" v-model="user.username" required>
                </div>
                <div class="form-group">
                    <label for="text">Password</label>
                    <input type="text" class="form-control" v-model="user.password" required>
                </div>
                <div class="form-group row justify-content-center m-3">
                    <button type="submit" class="btn btn-primary">Login</button>
                    <p>
                        <router-link to="/sign-up" class="form-group row justify-content-center m-3">Login</router-link>
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
    name: "LoginPage",
    props: {
        msg: String
    },
    data() {
        return {
            user: {
                username: "",
                password: "",
            }
        }
    },
    methods: {
        async login() {
            let result = await axios.get(`http://localhost:8080/api/v1/users/?username=${this.user.username}&password=${this.user.password}`)

            if (result.status == 200) {
                alert("Login success!!!")
                localStorage.setItem('user-info', JSON.stringify(result.data));
                this.$router.push({ name: "HomePage" });
            }
            // console.log(this.user.userUsername,this.user.userPassword)
            console.log(result.status, result.data.length);
        }
    },
    mounted() {
        let user = localStorage.getItem('user-info');
        if (user) {
            this.$router.push({ name: "HomePage" })
        }
    }
} 
</script>