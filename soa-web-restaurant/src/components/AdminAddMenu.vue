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
    <div class="row justify-content-center">
        <div class="col-md-6">
            <!-- Display List -->
            <!-- <h1 class="row justify-content-center">Show Users</h1> -->
            <!-- <button @click="getmenuss">menuss</button> -->
            <!-- <table class="table table-hover table-fixed"> -->
            <table class="table table-hover table-fixed">
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
                        <td><router-link
                                :to="{ name: 'UpdateMenuPage', params: { id: menu.menuId } }"><button>UPDATE</button></router-link>
                        </td>
                        <td><button @click="deleteMenu(menu.menuId)">DELETE</button></td>
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
            <div>
                <form @submit.prevent="addMenu">

                    <label>Menu Name:</label>
                    <input type="text" v-model="menuData.menuName" required>

                    <label>Menu Description:</label>
                    <input type="text" v-model="menuData.menuDescription" required>

                    <button type="submit">Add Menu</button>
                </form>

            </div>
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