<template>
    <div class="row justify-content-center">
        <div class="col-md-6">

            <table class="table table-hover table-fixed">
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
                        <td><router-link
                                :to="{ name: 'UpdateCoursePage', params: { id: courseMenu.courseMenuId } }"><button>UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteCourse(courseMenu.courseMenuId)">DELETE</button></td>
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
            <form @submit.prevent="addCourse">
                <!-- <label for="courseMenuId">Course Menu ID:</label>
                <input type="number" id="courseMenuId" v-model="courseMenu.courseMenuId"> -->
                <label for="courseMenuName">Course Menu Name:</label>
                <input type="text" id="courseMenuName" v-model="courseMenu.courseMenuName" required>
                <button type="submit">Add Course</button>
            </form>
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