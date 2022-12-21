<template>
    <div class="home">
        <div v-show="!success">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-3">
                        <div class="col-sm-6">
                            <h1>Daftar User</h1>
                        </div>
                    </div>
                    <div>
                        <div class="d-flex flex-row justify-content-between mr-3 mt-3">
                            <button class="btn btn-primary mr-2" @click="$router.back()" type="button">Back</button>
                            <input v-model="search" class="form-control mr-sm-2 w-25 " type="search" placeholder="Search">
                        </div>
                    </div>
                </div>
            </section>

            <section class="content">
                <div class="container-fluid">
                    <table class="table table-bordered table-hover table-responsive-sm table-light">
                        <thead>
                            <tr>
                                <th scope="col" width="10">No</th>
                                <th scope="col">Nama</th>
                                <th scope="col">Email</th>
                                <th scope="col" width="10">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan="6" class="text-center" v-if="UserData.length == 0">Tidak ada Data</td>
                            </tr>
                            <tr v-for="(item, index) in filterUser" :key="index">
                                <th scope="row">{{index+=1}}</th>
                                <td>{{ item.nama }}</td>
                                <td>{{ item.email }}</td>
                                <td class="d-flex">
                                    <router-link :to="{ name : 'DetailUserPage', params:{id:item.id}}">
                                        <button class="btn btn-sm btn-primary mr-2 text-white">
                                            Detail
                                        </button>
                                    </router-link>
                                    <button class="btn btn-sm btn-danger"
                                        @click="deleteUserFunction(item.id, item.nama)">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>

        <div v-show="!success">
            
        
        </div>
    </div>
</template>

<script>
// @ is an alias to /src
import eKtpServices from '@/services/eKtpServices';
import Swal from 'sweetalert2'

export default {
    name: 'UserPage',
    data() {
        return {
            UserData: [],
            success: false,
            search: '',
        };
    },
    mounted() {
        this.getAllUser();
    },
    methods: {
        getAllUser() {
            eKtpServices.getAllUser()
                .then((response) => {
                    this.UserData = response.data;
                })
                .catch((e) => {
                    console.log(e);
                });
        },

        deleteUserFunction(id, nama) {
            Swal.fire({
                title: "Anda Yakin Ingin Menghapus " + `${nama}` + "?",
                text: "Klik Batal Untuk Membatalkan Penghapusan",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Hapus"
            }).then(result => {
                if (result.value) { 
                    eKtpServices.deleteUser(id)
                        .then(response => {
                            console.log(response.data);
                            Swal.fire(
                                "Terhapus",
                                "Data Anda Sudah Tehapus",
                                "success"
                            ).then(() => {
                                location.reload();
                            });
                        })
                        .catch(e => {
                            console.log(e);
                            Swal.fire(
                                "Gagal",
                                "Data Gagal Terhapus",
                                "warning"
                            );
                        })
                    }
                })
            },
        },
    computed: {
        filterUser() {
            return this.UserData
                .filter(item => item.nama.toLowerCase().includes(this.search.toLowerCase())
                );
        }
    },
}
</script>
