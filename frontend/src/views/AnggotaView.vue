<template>
    <div class="about">
        <div class="container" v-show="success">
            <app-success />
        </div>

        <div v-show="!success">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6 ml-2">
                            <h1>Detail Kartu Keluarga</h1>
                            <button class="btn btn-primary mt-3 mr-2" type="button" @click="$router.back()">Back</button>
                            <button class="btn btn-success mt-3 mr-2" type="button" v-show="hideButton"
                                @click="updateFunction()">Update Kartu Keluarga</button>
                            <router-link :to="{ path: '/detail/' + KKData.id + '/list' }">
                                <button class="btn btn-info mt-3" type="button">Lihat Kartu Keluarga</button>
                            </router-link>
                        </div>
                    </div>
                </div>
            </section>

            <section class="content">
                <div class="container-fluid">
                    <form class="border p-5 bg-white" @submit.prevent="updateKK">
                        <div class="row d-flex justify-content-between">
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="nomor_kk" class="col-md-6 col-sm-2 col-form-label">Nomor Kartu
                                        Keluarga</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.nomor_kk" name="nomor_kk" type="number"
                                            class="form-control" id="nomor_kk" placeholder="Nomor Kartu Keluarga"
                                            :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="alamat" class="col-md-6 col-sm-2 col-form-label">Alamat</label>
                                    <div class="col-md-6 col-sm-10">
                                        <textarea v-model="KKData.alamat" name="alamat" id="alamat" class="form-control"
                                            rows="3" placeholder="Alamat Lengkap" :disabled="isDisabled"></textarea>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="rt" class="col-md-6 col-sm-2 col-form-label">RT</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.rt" name="rt" type="number" class="form-control" id="rt"
                                            placeholder="RT" :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="rw" class="col-md-6 col-sm-2 col-form-label">RW</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.rw" name="rw" type="number" class="form-control" id="rw"
                                            placeholder="RW" :disabled="isDisabled" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="desa_kelurahan" class="col-md-6 col-sm-2 col-form-label">Desa /
                                        Kelurahan</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.desa_kelurahan" name="desa_kelurahan" type="text"
                                            class="form-control" id="desa_kelurahan" placeholder="Desa / Kelurahan"
                                            :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="kecamatan" class="col-md-6 col-sm-2 col-form-label">Kecamatan</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.kecamatan" name="kecamatan" type="text"
                                            class="form-control" id="kecamatan" placeholder="Kecamatan"
                                            :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="kabupaten_kota" class="col-md-6 col-sm-2 col-form-label">Kabupaten /
                                        Kota</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.kabupaten_kota" name="kabupaten_kota" type="text"
                                            class="form-control" id="kabupaten_kota" placeholder="Kabupaten / Kota"
                                            :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="provinsi" class="col-md-6 col-sm-2 col-form-label">Provinsi</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.provinsi" name="provinsi" type="text"
                                            class="form-control" id="provinsi" placeholder="Provinsi"
                                            :disabled="isDisabled" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="kode_pos" class="col-md-6 col-sm-2 col-form-label">Kode Pos</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input v-model="KKData.kode_pos" name="kode_pos" type="number"
                                            class="form-control" id="kode_pos" placeholder="Kode Pos"
                                            :disabled="isDisabled" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <span class="btn btn-danger mr-2" @click="refreshFunction()" v-show="updateButton">Cancel</span>
                        <button class="btn btn-success" type="submit" v-show="updateButton">Update</button>
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
            KKData: {
                alamat: null,
                desa_kelurahan: null,
                kabupaten_kota: null,
                kecamatan: null,
                kode_pos: null,
                nomor_kk: null,
                provinsi: null,
                rt: null,
                rw: null,
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
        updateKK() {
            let data = this.KKData;
            let id = this.$route.params.id;
            eKtpServices.updateKK(id, data)
                .then((response) => {
                    console.log(response.data);
                    this.success = true;
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getKKById() {
            let id = this.$route.params.id;
            eKtpServices.getKKById(id)
                .then((response) => {
                    this.KKData = response.data;
                    console.log(this.KKData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        this.getKKById();
    },
}
</script>

<style>

</style>