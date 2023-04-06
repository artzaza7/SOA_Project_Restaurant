<template>
    <div class="body">
        <div class="">
            <div class="top-right">
                <form @submit.prevent="addCourse">
                    <!-- <label for="courseMenuId">Course Menu ID:</label>
                <input type="number" id="courseMenuId" v-model="courseMenu.courseMenuId"> -->
                    <div class="row justify-content-center">
                        <div class="col-md-3">
                            <!-- <div class="input-group-prepend"> -->
                            <span class="input-group-text" id="inputGroup-sizing-default">Course Menu Name</span>
                            <!-- </div> -->
                            <input type="text" class="form-control" aria-label="Small"
                                aria-describedby="inputGroup-sizing-sm" id="courseMenuName"
                                v-model="courseMenu.courseMenuName" required>
                            <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <button type="submit" class="btn btn-success btn-md mt-4">Add Course</button>
                                </div>
                            </div>

                        </div>
                    </div>


                </form>
            </div>
            <table class="mt-5 table table-hover table-fixed">
                <thead>
                    <tr>
                        <th>Course Menu ID</th>
                        <th>Course Menu Name</th>
                        <th>Update</th>
                        <th>Delete</th>
                        <!-- <th>Menu In Course ID</th>
                        <th>Reservation ID</th>
                        <th>Reservation Date</th>
                        <th>Reservation Time Start</th>
                        <th>Reservation Time End</th>
                        <th>Reservation Status</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="courseMenu in coursemenus" :key="courseMenu.menuInCourseId">
                        <td>{{ courseMenu.courseMenuId }}</td>
                        <td>{{ courseMenu.courseMenuName }}</td>
                        <td><router-link :to="{ name: 'UpdateCoursePage', params: { id: courseMenu.courseMenuId } }"><button
                                    class="btn btn-warning btn-sm">UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteCourse(courseMenu.courseMenuId)"
                                class="btn btn-danger btn-sm">DELETE</button></td>
                        <!-- <td>{{ menu.menuInCourseId }}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td> -->
                    </tr>
                    <!-- <tr v-for="reservation in coursemenus.reservations" :key="reservation.reservationId">
                        <td>{{ coursemenus.courseMenuId }}</td>
                        <td>{{ coursemenus.courseMenuName }}</td>
                        <td></td>
                        <td>{{ reservation.reservationId }}</td>
                        <td>{{ reservation.reservationDate }}</td>
                        <td>{{ reservation.reservationTimeStart }}</td>
                        <td>{{ reservation.reservationTimeEnd }}</td>
                        <td>{{ reservation.reservationStatus }}</td>
                    </tr> -->
                </tbody>
            </table>
        </div>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'AdminAddCoursePage',
    data() {
        return {
            coursemenus: null,
            courseMenu: {
                courseMenuName: "",
                menuInCourses: [],
                reservations: []
            }
        }
    },
    methods: {
        async getCourseMenus() {
            const response = await axios.get('http://localhost:8080/api/v1/coursemenus');
            this.coursemenus = response.data;
            console.log(response.data);
        },

        addCourse() {
            axios.post("http://localhost:8080/api/v1/coursemenus", this.courseMenu)
                .then(
                    ({ data }) => {
                        console.log(data);
                        alert("add success!!!");
                        this.courseMenu.menuName = '';
                        this.courseMenu.menuInCourses = [];
                        this.courseMenu.reservations = [];
                        window.location.reload();
                    }
                )
        },
        async deleteCourse(id) {
            await axios.delete(`http://localhost:8080/api/v1/coursemenus/${id}`)
            this.getCourseMenus();
        }
    },
    created() {
        this.getCourseMenus();
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