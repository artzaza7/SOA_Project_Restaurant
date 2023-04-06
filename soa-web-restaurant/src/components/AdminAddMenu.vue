<template>
    <!-- <div> -->
    <!-- <ul> -->
    <!-- <li v-for="menus in menuss" :key="menus.menusId"> -->
    <!-- sfsffds -->
    <!-- {{ menus.menusId }} - {{ menus.menusDate }} -->
    <!-- <button @click="editItem(menus)">Edit</button> -->
    <!-- <button @click="deletemenus(menus.menusId)">Delete</button> -->
    <!-- </li> -->
    <!-- </ul> -->
    <!-- </div> -->
    <div class="body">
        <div class="">
            <!-- Display List -->
            <!-- <h1 class="row justify-content-center">Show Users</h1> -->
            <!-- <button @click="getmenuss">menuss</button> -->
            <!-- <table class="table table-hover table-fixed"> -->
            <div class="top-right">
                <form @submit.prevent="addMenu">
                    <div class="row justify-content-center">
                        <div class="col-md-3">
                            <span class="input-group-text" id="inputGroup-sizing-sm">Menu Name</span>
                            <input type="text" class="form-control" aria-label="Small"
                                aria-describedby="inputGroup-sizing-sm" v-model="menuData.menuName" required>

                            <span class="input-group-text" id="inputGroup-sizing-sm">Menu Description</span>
                            <textarea class="form-control" rows="3" v-model="menuData.menuDescription" required />

                            <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <button type="submit" class="btn btn-success btn-md mt-4">Add Menu</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
            <table class="mt-5 table table-hover table-fixed">
                <thead>
                    <tr>
                        <th>Menu ID</th>
                        <th>Menu Name</th>
                        <th>Menu Description</th>
                        <!-- <th>Menu In Courses</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(menu, index) in menus" :key="index">
                        <td>{{ menu.menuId }}</td>
                        <td>{{ menu.menuName }}</td>
                        <td>{{ menu.menuDescription }}</td>
                        <td><router-link :to="{ name: 'UpdateMenuPage', params: { id: menu.menuId } }"><button
                                    class="btn btn-warning btn-sm">UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteMenu(menu.menuId)" class="btn btn-danger btn-sm">DELETE</button></td>
                        <!-- <td>
                            <ul>
                                <li v-for="(menuInCourse, index) in menu.menuInCourses" :key="index">
                                    {{ menuInCourse.menuInCourseId }}
                                </li>
                            </ul>
                        </td> -->
                    </tr>
                </tbody>
            </table>
        </div>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'AdminmenusPage',
    data() {
        return {
            menus: null,
            menuData:
            {
                menuName: "",
                menuDescription: "",
                menuInCourses: [],
            },
        }
    },
    methods: {
        async getMenus() {
            const response = await axios.get('http://localhost:8080/api/v1/menus');
            this.menus = response.data;
            console.log(response.data);
        },

        addMenu() {
            axios.post("http://localhost:8080/api/v1/menus", this.menuData)
                .then(
                    ({ data }) => {
                        console.log(data);
                        alert("add success!!!");
                        this.menuData.menuName = '';
                        this.menuData.menuDescription = '';
                        this.menuData.menuInCourses = [];
                        window.location.reload();
                    }
                )
        },
        async deleteMenu(id) {
            await axios.delete(`http://localhost:8080/api/v1/menus/${id}`)
            this.getMenus();
        }
    },
    created() {
        this.getMenus();
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