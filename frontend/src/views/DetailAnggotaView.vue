<template>
    <div class="updateAnggota">

        <div class="container" v-show="success">
            <app-success />
        </div>

        <div v-show="!success">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-3">
                        <div class="col-sm-6">
                            <h1>Update Anggota Keluarga</h1>
                        </div>
                    </div>
                    <div>
                        <button class="btn btn-primary mr-2" type="button" @click="$router.back()">Back</button>
                        <button class="btn btn-success" type="button" v-show="hideButton" @click="updateFunction()">Update Kartu
                            Keluarga</button>
                    </div>
                </div>
            </section>

            <section class="content">
                <div class="container-fluid">
                    <form action="" class="border p-5 bg-gradient-white" @submit.prevent="updateAnggota">
                        <div class="row d-flex justify-content-between">
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="nik" class="col-md-6 col-sm-2 col-form-label">NIK</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="number" class="form-control" id="nik" name="nik" placeholder="NIK"
                                            v-model="AnggotaData.nik" :disabled="isDisabled"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="nama" class="col-md-6 col-sm-2 col-form-label">Nama</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input name="nama" id="nama" class="form-control" rows="3"
                                            placeholder="Nama Lengkap" v-model="AnggotaData.nama" :disabled="isDisabled">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="jenis_kelamin" class="col-md-6 col-sm-2 col-form-label">Jenis
                                        Kelamin</label>
                                    <div class="col-md-6 col-sm-10">
                                        <select id="jenis_kelamin" v-model="AnggotaData.jenis_kelamin" :disabled="isDisabled"
                                            class="form-control" name="jenis_kelamin">
                                            <option disabled selected label="Pilih Jenis Kelamin"></option>
                                            <option id="pria">Pria</option>
                                            <option id="wanita">Wanita</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="tempat_lahir" class="col-md-6 col-sm-2 col-form-label">Tempat
                                        Lahir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="tempat_lahir" name="tempat_lahir" 
                                            placeholder="Tempat Lahir" v-model="AnggotaData.tempat_lahir" :disabled="isDisabled"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="tanggal_lahir" class="col-md-6 col-sm-2 col-form-label">Tanggal
                                        Lahir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="date" class="form-control" id="tanggal_lahir" name="tanggal_lahir"
                                            v-model="AnggotaData.tanggal_lahir" :disabled="isDisabled"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="agama" class="col-md-6 col-sm-2 col-form-label">Agama</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="agama" name="agama"
                                            placeholder="Agama" v-model="AnggotaData.agama" :disabled="isDisabled"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="pendidikan" class="col-md-6 col-sm-2 col-form-label">Pendidikan
                                        Terakhir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="pendidikan" name="pendidikan"
                                            placeholder="Pendidikan Terakhir" v-model="AnggotaData.pendidikan" :disabled="isDisabled"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="kepala_keluarga" class="col-md-6 col-sm-2 col-form-label">Kepala
                                        Keluarga</label>
                                    <div class="col-md-6 col-sm-10">
                                        <select id="kepala_keluarga" v-model="AnggotaData.kepala_keluarga" :disabled="isDisabled"
                                            class="form-control" name="kepala_keluarga">
                                            <option disabled selected label="Pilih Status"></option>
                                            <option id="yes">Yes</option>
                                            <option id="no">No</option>
                                        </select>
                                    </div>
                                </div>
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
// @ is an alias to /src
import eKtpServices from '@/services/eKtpServices';

export default {
    data() {
        return {
            AnggotaData: {
                nik: null,
                agama: null,
                nama: null,
                jenis_kelamin: null,
                tempat_lahir: null,
                tanggal_lahir: null,
                pendidikan: null,
                kepala_keluarga: null,
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
        updateAnggota() {
            let data = this.AnggotaData;
            let id_kk = this.$route.params.id;
            eKtpServices.updateAnggota(id_kk, data)
                .then((response) => {
                    console.log(response.data);
                    this.success = true;
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getAnggota() {
            // let id = this.$route.params.id;
            let id = this.$route.params.id_kk
            eKtpServices.getAnggota(id)
                .then((response) => {
                    this.AnggotaData = response.data;
                    console.log(this.AnggotaData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },

    },
    mounted() {
        // if (this.$route.name == "DetailAnggotaPage") {
        this.getAnggota();
        // }
    },
}
</script>
