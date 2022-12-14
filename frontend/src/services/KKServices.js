import http from '../http-common';

class KKServices {
  create(data) {
    return http.post("/kk/insert", data);
  }

  getAll() {
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
}

export default new KKServices();