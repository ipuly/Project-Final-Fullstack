<template>
  <body>
    <div class="container" v-show="success">
      <app-success />
    </div>
    <div class="container" id="container" v-show="!success">
      <div class="form-container sign-up-container">
        <form action="" @submit.prevent="registUser">
          <h1>Create Account</h1>
          <input 
            v-model="userData.nama"
            id="nama"
            name="nama"
            class="form-control" 
            type="text" 
            placeholder="Name" 
            required
          />
          <input
            v-model="userData.email"
            id="email"
            name="email" 
            class="form-control"
            type="email" 
            placeholder="Email" 
            required
          />
          <p v-show="check" class="font-weight-bold" style="color: red;">Email sudah terdaftar!</p>
          <input 
            v-model="userData.password"
            id="password"
            name="password"
            class="form-control" 
            type="password" 
            placeholder="Password" 
            required
          />
          <input 
            v-model="userData.password2" 
            class="form-control" 
            type="password" 
            placeholder="Password" 
            required
          />
          <p v-show="checkPassword" class="font-weight-bold" style="color: red;">Password tidak sama!</p>
          <button type="submit">Daftar</button>
        </form>
      </div>
      <div class="form-container sign-in-container">
        <form action="" @submit.prevent="loginUser">
          <h1>Login</h1>
          <input 
            v-model="loginData.email"
            class="form-control" 
            name="email" 
            id="email_login" 
            type="email" 
            placeholder="Email" 
            required
          />
          <input 
            v-model="loginData.password"
            class="form-control" 
            name="password" 
            id="password_login" 
            type="password" 
            placeholder="Password" 
            required
          />
          <!-- <span>
            <i class="fa fa-eye" aria-hidden="true" type="button" id="eye"></i>
          </span> -->
          <p v-show="check" class="font-weight-bold" style="color: red;">Email atau Password salah!</p>
          <button type="submit">Login</button>
        </form>
      </div>
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-left">
            <img src="@/assets/logo.png" class="img-fluid" width="200px" alt="eKTP Logo">
            <h1>Register</h1>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.</p>
            <button class="ghost" id="signIn">Sign In</button>
          </div>
          <div class="overlay-panel overlay-right">
            <img src="@/assets/logo.png" class="img-fluid" width="200px" alt="eKTP Logo">
            <h1>E KTP</h1>
            <p>Tidak punya akun? Daftarkan terlebih dahulu</p>
            <button class="ghost" id="signUp">Sign Up</button>
          </div>
        </div>
      </div>
    </div>
    
  </body>
</template>

<script>
import eKtpServices from '@/services/eKtpServices';

export default {
  data() {
    return {
      loginData: {
        email: null,
        password: null
      },
      userData: {
        nama: null,
        email: null,
        password: null,
        password2: null,
      },
      success: false,
      check: false,
      checkPassword: false,
    };
  },

  methods: {
    onClickTop() {
      this.$notify(
        {
          group: "top",
          title: "Success",
          text: "Your account was registered!"
        },
        4000
      );
    },
    registUser() {
      if (this.userData.password2 == this.userData.password) {
        let data = this.userData;
        eKtpServices
          .registUser(data)
          .then((response) => {
            console.log(response.data);
            this.success = true
          })
          .catch((e) => {
            console.log(e)
            if (e.response.data.trace.includes("Duplicate entry")) {
              this.check = true
            }
          });
      } else {
        this.checkPassword = true
      }
    },

    loginUser() {
      let data = this.loginData;
      eKtpServices
        .loginUser(data)
        .then((response) => {
          console.log(response.data);
          this.$router.push("/home")
        })
        .catch((e) => {
          if (e.response.data.trace.includes("Incorrect result")) {
            this.check = true
          } 
        });
    },

    loginsignup(){
      const signUpButton = document.getElementById('signUp');
      const signInButton = document.getElementById('signIn');
      const container = document.getElementById('container');

      signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
      });

      signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
      });
    }
  },
  mounted() {
    this.loginsignup()
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');

h1 {
  font-weight: bold;
  margin: 20px 0;
}

h2 {
  text-align: center;
}

p {
  font-size: 14px;
  font-weight: 100;
  line-height: 20px;
  letter-spacing: 0.5px;
}

span {
  font-size: 12px;
}

a {
  color: #333;
  font-size: 14px;
  text-decoration: none;
  margin: 15px 0;
}

button {
  border-radius: 20px;
  border: 1px solid #FF4B2B;
  background-color: #FF4B2B;
  color: #FFFFFF;
  font-size: 12px;
  font-weight: bold;
  padding: 12px 45px;
  margin-top: 20px;
  letter-spacing: 1px;
  text-transform: uppercase;
  transition: transform 80ms ease-in;
}

button:active {
  transform: scale(0.95);
}

button:focus {
  outline: none;
}

button.ghost {
  background-color: transparent;
  border-color: #FFFFFF;
}

form {
  background-color: #FFFFFF;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 50px;
  height: 100%;
  text-align: center;
}

input {
  padding: 12px 15px;
  margin: 8px 0;
  width: 100%;
}

.container {
  background-color: #fff;
  /* border-radius: 10px;
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25),
    0 10px 10px rgba(0, 0, 0, 0.22); */
  position: relative;
  overflow: hidden;
  /* margin-top: 95px; */
  /* width: 768px; */
  max-width: 100%;
  min-height: 100vh;
}

.form-container {
  position: absolute;
  top: 0;
  height: 100%;
  transition: all 0.6s ease-in-out;
}

.sign-in-container {
  left: 0;
  width: 50%;
  z-index: 2;
}

.container.right-panel-active .sign-in-container {
  transform: translateX(100%);
}

.sign-up-container {
  left: 0;
  width: 50%;
  opacity: 0;
  z-index: 1;
}

.container.right-panel-active .sign-up-container {
  transform: translateX(100%);
  opacity: 1;
  z-index: 5;
  animation: show 0.6s;
}

@keyframes show {

  0%,
  49.99% {
    opacity: 0;
    z-index: 1;
  }

  50%,
  100% {
    opacity: 1;
    z-index: 5;
  }
}

.overlay-container {
  position: absolute;
  top: 0;
  left: 50%;
  width: 50%;
  height: 100%;
  overflow: hidden;
  transition: transform 0.6s ease-in-out;
  z-index: 100;
}

.container.right-panel-active .overlay-container {
  transform: translateX(-100%);
}

.overlay {
  background: #0F2027;
  background: -webkit-linear-gradient(to right, #2C5364, #203A43, #0F2027);
  background: linear-gradient(to right, #2C5364, #203A43, #0F2027);
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0 0;
  color: #FFFFFF;
  position: relative;
  left: -100%;
  height: 100%;
  width: 200%;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
}

.container.right-panel-active .overlay {
  transform: translateX(50%);
}

.overlay-panel {
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 40px;
  text-align: center;
  top: 0;
  height: 100%;
  width: 50%;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
}

.overlay-left {
  transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
  transform: translateX(0);
}

.overlay-right {
  right: 0;
  transform: translateX(0);
}

.container.right-panel-active .overlay-right {
  transform: translateX(20%);
}

.social-container {
  margin: 20px 0;
}
</style>