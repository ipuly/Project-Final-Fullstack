import http from '../http-common';

class eKtpServices {
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

  createUser(data) {
    return http.post("/user/insert", data);
  }

  getAllUser() {
    return http.get("/user/getAll");
  }

  updateUser(id, data) {
    return http.put(`/user/update/${id}`, data);
  }

  deleteUser(id) {
    return http.delete(`/user/delete/${id}`);
  }

  getUserById(id) {
    return http.get(`/user/getData/${id}`)
  }

  getAnggotaByKk(id_kk) {
    return http.get(`/anggota/getIdKk/${id_kk}`)
  }

  updateAnggotaByKk(id_kk, data) {
    return http.put(`/anggota/updateKK/${id_kk}`, data);
  }
}

export default new eKtpServices();