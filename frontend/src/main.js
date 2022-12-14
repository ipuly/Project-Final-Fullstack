import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

import 'admin-lte/plugins/fontawesome-free/css/all.min.css'
import 'admin-lte/plugins/icheck-bootstrap/icheck-bootstrap.min.css'
import 'admin-lte/dist/css/adminlte.min.css?v=3.2.0'
import './style.scss'

import 'admin-lte/plugins/jquery/jquery.min.js'
import 'admin-lte/plugins/bootstrap/js/bootstrap.bundle.min.js'
import 'admin-lte/dist/js/adminlte.min.js?v=3.2.0'

import 'admin-lte/plugins/datatables/jquery.dataTables.min.js'
import 'admin-lte/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js'
import 'admin-lte/plugins/datatables-responsive/js/dataTables.responsive.min.js'
import 'admin-lte/plugins/datatables-responsive/js/responsive.bootstrap4.min.js'
import 'admin-lte/plugins/datatables-buttons/js/dataTables.buttons.min.js'
import 'admin-lte/plugins/datatables-buttons/js/buttons.bootstrap4.min.js'

/* ------------ Global Components -------------- */
import AppNavBar from './components/AppNavBar'
import AppSideBar from './components/AppSideBar'
import AppFooter from './components/AppFooter'
import AppSuccess from './components/AppSuccess'

Vue.component('AppNavBar', AppNavBar)
Vue.component('AppSideBar', AppSideBar)
Vue.component('AppFooter', AppFooter)
Vue.component('AppSuccess', AppSuccess)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
