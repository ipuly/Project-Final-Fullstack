<template>
  <div class="home">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Dashboard</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="content">
      <div class="container-fluid px-lg-4">
        <div class="row">
          <div class="col-sm-4">
            <div class="small-box bg-info">
              <div class="inner">
                <h3>{{ KKData.length }}</h3>
                <p>Kartu Keluarga</p>
              </div>
              <div class="icon">
                <i class="fas fa-users"></i>
              </div>
              <a class="small-box-footer"></a>
            </div>
          </div>
        
          <div class="col-sm-4">
            <div class="small-box bg-gradient-teal">
              <div class="inner">
                <h3>{{ AnggotaData.length }}</h3>
                <p>Penduduk</p>
              </div>
              <div class="icon">
                <i class="fas fa-user"></i>
              </div>
              <a class="small-box-footer"></a>
            </div>
          </div>
        
          <div class="col-sm-4">
            <div class="small-box bg-gradient-success">
              <div class="inner">
                <h3>{{ UserData.length }}</h3>
                <p>User</p>
              </div>
              <div class="icon">
                <i class="fas fa-user-plus"></i>
              </div>
              <a class="small-box-footer"></a>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2 col-sm-12">
          <div class="col-sm-6">
            <h1>Data Kartu Keluarga</h1>
          </div>
          <div class="col-sm-6">
            <input v-model="search" class="form-control mr-sm-2 w-25 " type="search" placeholder="Search">
          </div>
        </div>
      </div>
    </section>

    <section class="content">
      <div class="container-fluid">
        <table class="table table-bordered table-hover table-responsive-sm table-light" >
          <thead>
            <tr>
              <th scope="col" width="10">No</th>
              <th scope="col">Nomor KK</th>
              <th scope="col">Alamat</th>
              <th scope="col">Kota</th>
              <th scope="col">Kode Pos</th>
              <th scope="col" width="10">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="6" class="text-center font-weight-bold" v-if="KKData.length == 0">Tidak ada Data </td>
            </tr>
            <tr v-for="(item,index) in searchKK" :key="index">
              <th scope="row">{{index+=1}}</th>
              <td>{{ item.nomor_kk }}</td>
              <td>{{ item.alamat + ", " + item.desa_kelurahan + ", " + item.kecamatan }}</td>
              <td>{{ item.kabupaten_kota }}</td>
              <td>{{ item.kode_pos }}</td>
              <td class="d-flex">
                <router-link :to="{ path: '/detail/' + item.id }">
                  <button class="btn btn-sm btn-primary mr-2 text-white">
                    Detail
                  </button>
                </router-link>
                <router-link to="/home">
                  <button class="btn btn-sm btn-danger" @click="deleteKKFunction(item.id, item.nomor_kk)">
                    Delete
                  </button>
                </router-link>
              </td>
            </tr>          
          </tbody>
        </table>
      </div>
    </section>

  </div>
</template>

<script>
// @ is an alias to /src
import eKtpServices from '@/services/eKtpServices';
import Swal from 'sweetalert2';

export default {
  name: 'HomePage',
  data() {
    return {
      KKData: [],
      AnggotaData: [],
      UserData: [],
      success: false,
      search: ''
    };
  },
  mounted() {
    this.getKK();
    this.getAnggota();
    this.getUser();
  },
  methods: {
    getKK() {
      eKtpServices.getAllKK()
        .then((response) => {
          this.KKData = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getAnggota() {
      eKtpServices.getAllAnggota()
        .then((response) => {
          this.AnggotaData = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getUser() {
      eKtpServices.getAllUser()
        .then((response) => {
          this.UserData = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteKKFunction(id, nomor_kk) {
      Swal.fire({
        title: "Anda Yakin Ingin Menghapus " + `${nomor_kk}` + "?",
        text: "Klik Batal Untuk Membatalkan Penghapusan",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Hapus"
      }).then(result => {
        if (result.value) {
          eKtpServices.deleteKK(id)
            .then(response => {
              console.log(response.data);
              eKtpServices.deleteAllAnggota(id)
                .then(response => {
                  console.log(response)
                  Swal.fire(
                    "Terhapus",
                    "Data Anda Sudah Tehapus",
                    "success"
                  ).then(() => {
                    location.reload();
                  });
                })
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
    searchKK() {
      return this.KKData.filter(item => 
        String(item.nomor_kk).includes(this.search)
      );
    }
  },
  
}
</script>
