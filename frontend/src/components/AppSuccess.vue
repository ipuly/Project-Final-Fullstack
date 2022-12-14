<template>
    <div class="card-body border">
        <h5 class="card-title">Success!</h5>
        <p class="card-text">Data has been <strong> {{ messages }}! </strong></p>
        <router-link to="/" v-if="messages == 'Inputed'" class="btn btn-primary">Close</router-link>
        <router-link to="/" v-else-if="messages == 'Updated'" class="btn btn-primary">Close</router-link>
        <button v-else class="btn btn-primary" @click="reloadPage">Close</button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            messages: null,
        }
    },
    methods: {
        ubahMessages() {
            let route = this.$route.fullPath;
            if (route === "/add") {
                this.messages = "Inputed";
            } else if (route === "/") {
                this.messages = "Deleted";
            } else {
                this.messages = "Updated";
            }
        },
        reloadPage() {
            location.reload();
        }
    },
    mounted() {
        this.ubahMessages();
    }
}
</script>

<style lang="scss">

</style>