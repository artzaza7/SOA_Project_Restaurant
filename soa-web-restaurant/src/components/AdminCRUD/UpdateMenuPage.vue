
<template>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div>
                <form @submit.prevent="updateMenu">

                    <label>Menu Name:</label>
                    <input type="text" v-model="menuData.menuName" required>

                    <label>Menu Description:</label>
                    <input type="text" v-model="menuData.menuDescription" required>

                    <button type="submit">Update Menu</button>
                </form>

            </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'UpdateMenuPage',
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
            const response = await axios.get(`http://localhost:8080/api/v1/menus/${this.$route.params.id}`);
            this.menus = response.data;
            console.log(response.data);
        },
        async updateMenu() {
            const response = await axios.put(`http://localhost:8080/api/v1/menus/${this.$route.params.id}`, this.menuData);
            console.log(response.data);
            this.$router.push('/addmenu')
        },
    },
    created() {
        this.getMenus();
    }
}
</script>