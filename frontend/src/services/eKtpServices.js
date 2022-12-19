import http from '../http-common';

class eKtpServices {

  // Kartu Keluarga Service
  createKK(data) {
    return http.post("/kk/insert", data);
  }

  getAllKK() {
    return http.get("/kk/getAll");
  }

  updateKK(id, data) {
    return http.put(`/kk/update/${id}`, data);
  }

  deleteKK(id) {
    return http.delete(`/kk/delete/${id}`);
  }

  getKKById(id) {
    return http.get(`/kk/getData/${id}`)
  }

  // Anggota Keluarga Service
  createAnggota(data) {
    return http.post("/anggota/insert", data);
  }

  getAllAnggota() {
    return http.get("/anggota/getAll");
  }

  updateAnggota(id, data) {
    return http.put(`/anggota/update/${id}`, data);
  }

  deleteAnggota(id) {
    return http.delete(`/anggota/delete/${id}`);
  }

  deleteAllAnggota(id_kk) {
    return http.delete(`/anggota/deleteAllAnggota/${id_kk}`);
  }

  getAnggota(id) {
    return http.get(`/anggota/getAnggota/${id}`)
  }

  getAnggotaByKk(id_kk) {
    return http.get(`/anggota/getIdKk/${id_kk}`)
  }

  updateAnggotaByKk(id_kk, data) {
    return http.put(`/anggota/updateKK/${id_kk}`, data);
  }

  // User Service
  registUser(data) {
    return http.post("/user/insert", data);
  }

  loginUser(data) {
    return http.post("/user/getUser", data);
  }

  getAllUser() {
    return http.get("/user/getAllUser");
  }
}

export default new eKtpServices();