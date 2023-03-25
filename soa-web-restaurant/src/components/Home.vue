<template>
    <h1>Home page</h1>
</template>

<script>

export default {
    name: 'HomePage',
    props: {
        msg: String
    },
    mounted() {
        let user = localStorage.getItem('user-info');
        if (!user) {
            this.$router.push({ name: "SignUpPage" })
        }
    }
}
</script>