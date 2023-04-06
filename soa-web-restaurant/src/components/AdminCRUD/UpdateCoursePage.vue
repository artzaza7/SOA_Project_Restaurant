
<template>
    <div class="row justify-content-center">
        <form @submit.prevent="updateCourse">
        <!-- <label for="courseMenuId">Course Menu ID:</label>
                            <input type="number" id="courseMenuId" v-model="courseMenu.courseMenuId"> -->
            <label for="courseMenuName">Course Menu Name:</label>
            <input type="text" id="courseMenuName" v-model="courseMenu.courseMenuName" required>
            <button type="submit">Update Course</button>
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