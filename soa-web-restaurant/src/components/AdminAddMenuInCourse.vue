<template lang="">
     <div class="body">

        <div>
            <form @submit.prevent="addMenuInCourse">

                <div class="row justify-content-center">
                        <div class="col-md-3">

                            <span class="input-group-text" id="inputGroup-sizing-sm">Select Menu</span>
                            <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example"
                                v-model="menuInCourse.menuId" required>
                                <option v-for="menu in menus" v-bind:key="menu.menuId"
                                    v-bind:value="menu.menuId">{{ menu.menuName }}</option>
                            </select>
                            <br>

                            <span class="input-group-text" id="inputGroup-sizing-sm">Select Course</span>
                            <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example"
                                v-model="menuInCourse.courseMenuId" required>
                                <option v-for="course in courses" v-bind:key="course.courseMenuId"
                                    v-bind:value="course.courseMenuId">{{ course.courseMenuName }}</option>
                            </select>
                            <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <button type="submit" class="btn btn-success btn-md mt-4">Add Menu In Course</button>
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
    data() {
        return {
            menuInCourse: {
                menuId: null,
                courseMenuId: null
            },
            menus: null,
            courses: null,
        }
    },
    methods:{
        async addMenuInCourse(){
            console.log(this.menuInCourse)
            axios.post("http://localhost:8080/api/v1/menuInCourse", this.menuInCourse)
                .then(
                    ({ data }) => {
                        console.log(data);
                        alert("Add success!!!");
                        this.menuInCourse.menuId = null;
                        this.menuInCourse.courseMenuId = null;
                        window.location.reload();
                    }
                )
        }
    },
    created() {
        axios
            .get(`http://localhost:8080/api/v1/coursemenus`)
            .then(response => {
                this.courses = response.data;
                console.log(this.courses)
            }).catch(error => {
                console.log(error);
            });

        axios
            .get(`http://localhost:8080/api/v1/menus`)
            .then(response => {
                this.menus = response.data;
                console.log(this.menus)
            }).catch(error => {
                console.log(error);
            });
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