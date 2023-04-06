
<template>
    <div class="body">
        <form @submit.prevent="updateCourse">
            <div class="row justify-content-center">
                <div class="col-md-3">
                    <!-- <div class="input-group-prepend"> -->
                    <span class="input-group-text" id="inputGroup-sizing-default">Course Menu Name</span>
                    <!-- </div> -->
                    <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                        id="courseMenuName" v-model="courseMenu.courseMenuName" required>
                    <div class="row justify-content-center">
                        <div class="col-md-4 row">
                            <router-link to="/addcourse"><button type="button"
                                    class="btn btn-light mt-3">Cancel</button></router-link>
                        </div>
                        <div class="col-md-4 ml-4">
                            <button type="submit" class="btn btn-success btn-md mt-3">Update</button>
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
    name: 'UpdateCousePage',
    data() {
        return {

            courseMenu: {
                courseMenuName: "",
                menuInCourses: [],
                reservations: []
            }
        }
    },
    methods: {
        async getCourse() {
            const response = await axios.get(`http://localhost:8080/api/v1/coursemenus/${this.$route.params.id}`);
            this.courseMenu = response.data;
            console.log(response.data);
        },
        async updateCourse() {
            const response = await axios.put(`http://localhost:8080/api/v1/coursemenus/${this.$route.params.id}`, this.courseMenu);
            console.log(response.data);
            this.$router.push('/addcourse')
        },
    },
    created() {
        this.getCourse();
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