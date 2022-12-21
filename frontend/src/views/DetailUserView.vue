<template>
    <div class="about">
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6 ml-2">
                        <h1>Detail User</h1>
                        <button v-show="!success" @click.prevent="$router.back()" class="btn btn-primary mt-3 mr-2" type="button">Back</button>
                        <button class="btn btn-success mt-3 mr-2" type="button" v-show="hideButton && !success"
                            @click="updateFunction()">Update User</button>
                    </div>
                </div>
            </div>
        </section>

        <div class="container" v-show="success">
            <app-success />
        </div>

        <div v-show="!success">
            <section class="content">
                <div class="container-fluid">
                    <form action="" class="border p-5 bg-gradient-white" @submit.prevent="updateUser">
                        <div class="row d-flex justify-content-between">
                            <div class="col-12">
                                <div class="form-group row">
                                    <label for="nama" class="col-md-4 col-sm-2 col-form-label">Nama</label>
                                    <div class="col-md-8 col-sm-10">
                                        <input type="text" class="form-control" placeholder="Nama Lengkap"
                                            v-model="updateUserData.nama" :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="email" class="col-md-4 col-sm-2 col-form-label">Email</label>
                                    <div class="col-md-8 col-sm-10">
                                        <input class="form-control" type="email" rows="3" placeholder="Email"
                                            v-model="updateUserData.email" :disabled="isDisabled">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="password" class="col-md-4 col-sm-2 col-form-label">Password</label>
                                    <div class="col-md-8 col-sm-10">
                                        <input class="form-control" type="text" rows="3" placeholder="Password"
                                            v-model="updateUserData.password" :disabled="isDisabled">
                                    </div>
                                </div>
                                <!-- <div class="form-group row">
                                    <label for="password2" class="col-md-4 col-sm-2 col-form-label">Re Password</label>
                                    <div class="col-md-8 col-sm-10">
                                        <input type="password" class="form-control" placeholder="Re Password"
                                            v-model="updateUserData.password2" :disabled="isDisabled" />
                                    </div>
                                </div> -->
                            </div>
                        </div>
                        <span class="btn btn-danger mr-2 mt-3" @click="refreshFunction()" v-show="updateButton">Cancel</span>
                        <button type="submit" v-show="updateButton" class="btn btn-primary mt-3">Submit</button>
                    </form>
                </div>
            </section>
        </div>
    </div>
</template>

<script>
import eKtpServices from '@/services/eKtpServices';

export default {
    data() {
        return {
            updateUserData: {
                nama: null,
                email: null,
                password: null,
                // password2: null,
            },
            success: false,
            updateButton: false,
            hideButton: true,
            isDisabled: true,
        }
    },
    methods: {
        updateFunction() {
            this.updateButton = true
            this.hideButton = false
            this.isDisabled = false
        },
        refreshFunction() {
            this.updateButton = false
            this.hideButton = true
            this.isDisabled = true

        },
        updateUser() {
            let data = this.updateUserData;
            let id = this.$route.params.id;
            eKtpServices.updateUser(id, data)
                .then((response) => {
                    console.log(response.data);
                    this.success = true;
                })
        },
        getUserById() {
            let id = this.$route.params.id;
            eKtpServices.getUserById(id)
                .then((response) => {
                    this.updateUserData = response.data;
                    console.log(this.updateUserData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        this.getUserById();
    },
}
</script>

<style>

</style>