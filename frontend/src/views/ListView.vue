<template>
    <div class="home">
        
        <div class="container" v-show="success">
            <app-success />
        </div>

        <div v-show="!success">
            <section class="content-header" v-show="!addAnggota">
                <div class="container-fluid">
                    <div class="row mb-3">
                        <div class="col-sm-6">
                            <h1>Daftar Anggota Keluarga</h1>
                        </div>
                    </div>
                    <div>
                        <button class="btn btn-primary mr-2" @click="$router.back()" type="button">Back</button>
                        <button class="btn btn-info" type="button" @click.prevent="tambahAnggota()" >Tambah Anggota Keluarga</button>
                    </div>
                </div>
            </section>

            <section class="content-header" v-show="addAnggota">
                <div class="container-fluid">
                    <div class="row mb-3">
                        <div class="col-sm-6">
                            <h1>Tambah Anggota Keluarga</h1>
                        </div>
                    </div>
                    <div>
                        <button class="btn btn-primary mr-2" type="button" @click.prevent="listAnggota()">Back</button>
                    </div>
                </div>
            </section>

            <section class="content" v-show="!addAnggota">
                <div class="container-fluid">
                    <table class="table table-bordered table-hover table-responsive-sm table-light">
                        <thead>
                            <tr>
                                <th scope="col" width="10">No</th>
                                <th scope="col">NIK</th>
                                <th scope="col">Nama</th>
                                <th scope="col">Jenis Kelamin</th>
                                <th scope="col">Kepala Keluarga</th>
                                <th scope="col" width="10">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan="6" class="text-center" v-if="AnggotaData.length == 0">Tidak ada Data</td>
                            </tr>
                            <tr v-for="(item, index) in AnggotaData" :key="index">
                                <th scope="row">{{index+=1}}</th>
                                <td>{{ item.nik }}</td>
                                <td>{{ item.nama }}</td>
                                <td>{{ item.jenis_kelamin }}</td>
                                <td>{{ item.kepala_keluarga }}</td>
                                <td class="d-flex">
                                    <router-link :to="{ name : 'DetailAnggotaPage', params:{id_kk:item.id}}">
                                        <button class="btn btn-sm btn-primary mr-2 text-white">
                                            Detail
                                        </button>
                                    </router-link>
                                    <button class="btn btn-sm btn-danger"
                                        @click="deleteAnggotaFunction(item.id, item.nik)">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>

            <section class="content" v-show="addAnggota">
                <div class="container-fluid">
                    <form action="" class="border p-5 bg-gradient-white" @submit.prevent="inputAnggota">
                        <div class="row d-flex justify-content-between">
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="nik" class="col-md-6 col-sm-2 col-form-label">NIK</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="number" class="form-control" id="nik" name="nik"
                                            placeholder="NIK" v-model="AnggotaInput.nik" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="nama" class="col-md-6 col-sm-2 col-form-label">Nama</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input name="nama" id="nama" class="form-control" rows="3"
                                            placeholder="Nama Lengkap" v-model="AnggotaInput.nama">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="jenis_kelamin" class="col-md-6 col-sm-2 col-form-label">Jenis Kelamin</label>
                                    <div class="col-md-6 col-sm-10">
                                        <select id="jenis_kelamin" v-model="AnggotaInput.jenis_kelamin" class="form-control" name="jenis_kelamin">
                                            <option disabled selected label="Pilih Jenis Kelamin"></option>
                                            <option id="pria">Pria</option>
                                            <option id="wanita">Wanita</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="tempat_lahir" class="col-md-6 col-sm-2 col-form-label">Tempat Lahir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="tempat_lahir" name="tempat_lahir" placeholder="Tempat Lahir"
                                            v-model="AnggotaInput.tempat_lahir" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="tanggal_lahir" class="col-md-6 col-sm-2 col-form-label">Tanggal Lahir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="date" class="form-control" id="tanggal_lahir" name="tanggal_lahir"
                                            v-model="AnggotaInput.tanggal_lahir" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="agama" class="col-md-6 col-sm-2 col-form-label">Agama</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="agama" name="agama"
                                            placeholder="Agama" v-model="AnggotaInput.agama" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="pendidikan" class="col-md-6 col-sm-2 col-form-label">Pendidikan Terakhir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="pendidikan" name="pendidikan"
                                            placeholder="Pendidikan Terakhir" v-model="AnggotaInput.pendidikan" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="kepala_keluarga" class="col-md-6 col-sm-2 col-form-label">Kepala Keluarga</label>
                                    <div class="col-md-6 col-sm-10">
                                        <select id="kepala_keluarga" v-model="AnggotaInput.kepala_keluarga" class="form-control" name="kepala_keluarga" required>
                                            <option disabled selected label="Pilih Status"></option>
                                            <option id="yes">Yes</option>
                                            <option id="no">No</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary mt-3">Submit</button>
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
    name: 'ListPage',
    data() {
        return {
            KKData: [],
            AnggotaData: [],
            AnggotaInput: {
                nik: null,
                agama: null,
                nama: null,
                jenis_kelamin: null,
                tempat_lahir: null,
                tanggal_lahir: null,
                pendidikan: null,
                kepala_keluarga: null,
                id_kk: this.$route.params.id,
            },
            success: false,
            addAnggota: false,
        };
    },
    mounted() {
        this.getAnggotaByKk();
    },
    methods: {
        inputAnggota() {
            let data = this.AnggotaInput;
            eKtpServices
                .createAnggota(data)
                .then(
                    this.success = true)
                .catch((e) => {
                    console.log(e);
                });
        },
        tambahAnggota(){
            this.addAnggota = true;
        },
        listAnggota() {
            this.addAnggota = false;
        },
        getKK() {
            eKtpServices.getAllKK()
                .then((response) => {
                    this.KKData = response.data;
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        deleteAnggotaFunction(id, nik) {
            if (confirm(`Apakah anda yakin hapus data ${nik} ?`)) {
                eKtpServices.deleteAnggota(id)
                    .then(response => {
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    })
                location.reload();
            } else {
                alert("Hapus dibatalkan!")
            }
        },
        getAnggotaByKk() {
            let id_kk = this.$route.params.id;
            eKtpServices.getAnggotaByKk(id_kk)
                .then((response) => {
                    this.AnggotaData = response.data;
                    console.log(this.AnggotaData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
}
</script>
