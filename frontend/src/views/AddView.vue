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
              <h1>Tambah Kartu Keluarga</h1>
                <button class="btn btn-primary mt-3" type="button" @click="$router.back()">Back</button>
            </div>
          </div>
        </div>
      </section>

      <section class="content">
        <div class="container-fluid">
          <form action="" class="border p-5 bg-gradient-white" @submit.prevent="inputKK">
            <div class="row d-flex justify-content-between">
              <div class="col-6">
                <div class="form-group row">
                  <label for="nomor_kk" class="col-md-6 col-sm-2 col-form-label">Nomor Kartu Keluarga</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="number" class="form-control" id="nomor_kk" name="nomor_kk" placeholder="Nomor Kartu Keluarga" v-model="KKData.nomor_kk" />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="alamat" class="col-md-6 col-sm-2 col-form-label">Alamat</label>
                  <div class="col-md-6 col-sm-10">
                    <textarea name="alamat" id="alamat" class="form-control" rows="3" placeholder="Alamat Lengkap" v-model="KKData.alamat"></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="rt" class="col-md-6 col-sm-2 col-form-label">RT</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="number" class="form-control" id="rt" name="rt" placeholder="RT" v-model="KKData.rt"/>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="rw" class="col-md-6 col-sm-2 col-form-label">RW</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="number" class="form-control" id="rw" name="rw" placeholder="RW" v-model="KKData.rw"/>
                  </div>
                </div>
              </div>
              <div class="col-6">
                <div class="form-group row">
                  <label for="desa_kelurahan" class="col-md-6 col-sm-2 col-form-label">Desa / Kelurahan</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="text" class="form-control" id="desa_kelurahan" name="desa_kelurahan" placeholder="Desa / Kelurahan" v-model="KKData.desa_kelurahan"/>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="kecamatan" class="col-md-6 col-sm-2 col-form-label">Kecamatan</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="text" class="form-control" id="kecamatan" name="kecamatan" placeholder="Kecamatan" v-model="KKData.kecamatan"/>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="kabupaten_kota" class="col-md-6 col-sm-2 col-form-label">Kabupaten / Kota</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="text" class="form-control" id="kabupaten_kota" name="kabupaten_kota" placeholder="Kabupaten / Kota" v-model="KKData.kabupaten_kota"/>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="provinsi" class="col-md-6 col-sm-2 col-form-label">Provinsi</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="text" class="form-control" id="provinsi" name="provinsi" placeholder="Provinsi" v-model="KKData.provinsi"/>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="kode_pos" class="col-md-6 col-sm-2 col-form-label">Kode Pos</label>
                  <div class="col-md-6 col-sm-10">
                    <input type="number" class="form-control" id="kode_pos" name="kode_pos" placeholder="Kode Pos" v-model="KKData.kode_pos"/>
                  </div>
                </div>
              </div>
            </div>
            <p v-show="checkNoKk" class="font-weight-bold" style="color: red;">Nomor KK sudah terdaftar!</p>
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
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
        kebupaten_kota: null,
        kecamatan: null,
        kode_pos: null,
        nomor_kk: null,
        provinsi: null,
        rt: null,
        rw: null,
      },
      success: false,
      checkNoKk: false,
    };
  },
  methods: {
    inputKK() {
      let data = this.KKData;
      eKtpServices
        .createKK(data)
        .then((response) => {
          console.log(response.data);
          this.success = true
        })
        .catch((e) => {
          if (e.response.data.trace.includes("Duplicate entry")) {
            this.checkNoKk = true
          }
      });
    },
  },
};
</script>

<style>

</style>