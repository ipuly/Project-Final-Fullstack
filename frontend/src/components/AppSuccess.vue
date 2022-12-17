<template>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h5 class="card-header">Success!</h5>
                <p class="card-body">Data has been <strong> {{ messages }}! </strong></p>
                <button @click="refresh()" v-if="messages == 'Inputed'" class="btn btn-primary">Close</button>
                <button @click="refresh()" v-else-if="messages == 'Updated'" class="btn btn-primary">Close</button>
                <button @click="refresh()" v-else class="btn btn-primary" >Close</button>
            </div>
        </div>
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
            let route = this.$route.name;
            if (route === "addPage") {
                this.messages = "Inputed";
            } else {
                this.messages = "Updated";
            }
        },
        refresh(){
            location.reload()
        }
        
    },
    mounted() {
        this.ubahMessages();
    }
}
</script>

<style lang="scss">

</style>