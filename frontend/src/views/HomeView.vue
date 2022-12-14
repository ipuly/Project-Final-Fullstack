<template>
  <div class="home">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Dashboard</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item active">Home</li>
            </ol>
          </div>
        </div>
      </div>
    </section>

    <section class="content">
      <div class="container-fluid px-lg-4">
        <div class="row">
          <div class="col-sm-4">
            <div class="card">
              <div class="card-body d-flex flex-column">
                <h5 class="card-title mb-3">Jumlah Kartu Keluarga</h5>
                  <div class="d-flex justify-content-between">
                    <h2 class="card-text">{{ KKData.length }}</h2>
                    <h1><i class="fas fa-users"></i></h1>
                  </div>
              </div>
            </div>
          </div>
        
          <div class="col-sm-4">
            <div class="card">
              <div class="card-body d-flex flex-column">
                <h5 class="card-title mb-3">Jumlah Penduduk</h5>
                <div class="d-flex justify-content-between">
                  <h2 class="card-text">0</h2>
                  <h1><i class="fas fa-user"></i></h1>
                </div>
              </div>
            </div>
          </div>
        
          <div class="col-sm-4">
            <div class="card">
              <div class="card-body d-flex flex-column">
                <h5 class="card-title mb-3">Jumlah Pengguna</h5>
                <div class="d-flex justify-content-between">
                  <h2 class="card-text">0</h2>
                  <h1><i class="fas fa-user-tie"></i></h1>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Data Kartu Keluarga</h1>
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
              <td colspan="6" class="text-center" v-if="KKData.length == 0">Tidak ada Data</td>
            </tr>
            <tr v-for="(item,index) in KKData" :key="index">
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
                <router-link to="/">
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
import KKServices from '@/services/KKServices';

export default {
  name: 'HomeView',
  data() {
    return {
      KKData: [],
      success: false,
    };
  },
  mounted() {
    this.getKK();
  },
  methods: {
    getKK() {
      KKServices.getAll()
        .then((response) => {
          this.KKData = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteKKFunction(id, nomor_kk) {
      if (confirm(`Apakah anda yakin hapus data ${nomor_kk} ?`)) {
        KKServices.deleteKK(id)
          .then(response => {
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
          location.reload();
        this.success = true;
      } else {
        alert("Hapus dibatalkan!")
      }
    },
  },
}
</script>
