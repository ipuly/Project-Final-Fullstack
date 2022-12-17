import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
  {
    path: '/home',
    // name: 'DefaultLayout',
    component: () => import('../layouts/DefaultLayout'),
    children: [
      {
        path: '/home',
        name: 'HomePage',
        component: () => import('../views/HomeView')
      },
      {
        path: '/add',
        name: 'AddPage',
        component: () => import('../views/AddView')
      },
      {
        path: '/detail/:id',
        name: 'DetailPage',
        component: () => import('../views/DetailView')
      },
      {
        path: '/detail/:id/list',
        name: 'ListPage',
        component: () => import('../views/ListView')
      },
      {
        path: '/detail/:id/list/detailAnggota/:id_kk',
        name: 'DetailAnggotaPage',
        component: () => import('../views/DetailAnggotaView')
      },
    ]
  },
  {
    path: '/',
    // name: 'DefaultLayout',
    component: () => import('../layouts/BlankLayout'),
    children: [
      {
        path: '/',
        name: 'login',
        component: () => import('../views/auth/Login.vue')
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
