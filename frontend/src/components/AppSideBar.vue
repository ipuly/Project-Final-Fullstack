<template>
  <aside class="main-sidebar sidebar-dark-light d-flex flex-column justify-content-between elevation-3">
    <a href="" class="brand-link elevation-3">
      <img src="@/assets/logo.png" alt="E KTP App" class="brand-image logo elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-bold ml-3">E KTP App</span>
    </a>
  <div class="sidebar">
    <nav class="mt-4">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <li class="nav-item">
          <router-link to="/home" class="nav-link text-white">
            <i class="fas fa-home"></i>
            <p class="ml-2">Home</p>
          </router-link>
        </li>
        <li class="nav-item mt-3">
          <router-link to="/add" class="nav-link text-white">
            <i class="fas fa-user-plus"></i>
            <p class="ml-2">Kartu Keluarga</p>
          </router-link>
        </li>
      </ul>
    </nav>
  </div>

    <div class="sidebar mb-4">
      <nav class="">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <router-link to="/" class="nav-link text-white">
              <i class="fas fa-sign-out-alt"></i>
              <p class="ml-2">Log Out</p>
            </router-link>
          </li>
        </ul>
      </nav>
    </div>
  </aside>
</template>

<script>
export default {
  name: 'AppSideBar',
  data() {
    return {

    }
  }
}
</script>

<style lang="scss">

</style>