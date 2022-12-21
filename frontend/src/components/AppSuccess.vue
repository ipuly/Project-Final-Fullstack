<template>
    <div class="container d-flex flex-row justify-content-center align-items-center">
        <div class="card">
            <div class="card-body">
                <h5 class="card-header">Sukses!</h5>
                <p class="card-body">Data Berhasil <strong> {{ messages }} </strong></p>
                <button @click="refresh()" class="btn btn-primary">Close</button>
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
            if (route === "AddPage" || route === 'ListPage' ) {
                this.messages = "Ditambahkan!";
            } else if (route === 'DetailPage' || route === 'DetailAnggotaPage' || route === 'DetailUserPage') {
                this.messages = "Diupdate!";
            } else {
                this.messages = "Terdaftar!"
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

<style scoped lang="scss">

</style>