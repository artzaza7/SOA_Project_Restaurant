
<template>
    <div class="body">
        <div class="">

            <form @submit.prevent="updateMenu">

                <div class="row justify-content-center">
                    <div class="col-md-3">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Menu Name</span>
                        <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                            v-model="menuData.menuName" required>

                        <span class="input-group-text" id="inputGroup-sizing-sm">Menu Description</span>
                        <textarea class="form-control" rows="3" v-model="menuData.menuDescription" required />

                        <div class="row justify-content-center">
                            <div class="col-md-4 row">
                                <router-link to="/addmenu"><button type="button"
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

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'UpdateMenuPage',
    data() {
        return {
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
            this.menuData = response.data;
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

<style scoped>
.body {
    border-radius: 20px;
    background-color: #ffffff;
    padding: 50px;
    box-shadow: 0 4px 8px 0 rgba(199, 199, 199, 0.2), 0 6px 20px 0 rgba(70, 70, 70, 0.19);
}
</style>