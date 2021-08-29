<template>
  <div id="register" class="text-center">
    <div class="container">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <p class="pleaseFillInForm">
          Please fill in this form to create an account.
        </p>

        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <label for="username" class="sr-only"></label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
          
        />
        <label for="password" class="sr-only"></label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <label for="confirmPassword" class="sr-only"></label>
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <div>
          <label for="user-type" class="sr-only">Account Type</label>
          <select id="user-type" name="user-type" class="sr-only" v-model="user.role">
            <option value=""> </option>
            <option value="admin">Doctor</option>
            <option value="user">Patient</option>
          </select>
          <label for="firstName" class="sr-only"></label>
          <input
            type="text"
            id="firstName"
            class="form-control"
            placeholder="First Name"
            v-model="user.firstName"
            required
          />
          <label for="lastName" class="sr-only"></label>
          <input
            type="text"
            id="lastName"
            class="form-control"
            placeholder="Last Name"
            v-model="user.lastName"
            required
          />
          <label for="phone" class="sr-only"></label>
          <input
            type="text"
            id="phone"
            class="form-control"
            placeholder="Phone Number"
            v-model="user.phone"
            required
          />
        </div>
        <div>
          <label for="address" class="sr-only"></label>
          <input
            type="text"
            id="address"
            class="form-control"
            placeholder="Address"
            v-model="user.address"
            required
          />
          <label for="city" class="sr-only"></label>
          <input
            type="text"
            id="city"
            class="form-control"
            placeholder="City"
            v-model="user.city"
            required
          />
          <label for="state" class="sr-only"></label>
          <input
            type="text"
            id="state"
            class="form-control"
            placeholder="state"
            v-model="user.state"
            required
          />
          <label for="zipCode" class="sr-only"></label>
          <input
            type="text"
            id="zipCode"
            class="form-control"
            placeholder="Zip Code"
            v-model="user.zipCode"
            required
          />
          <div id="birthdate">
            <label for="birthdate">Birth Date:</label>
            <input
              type="date"
              id="birthdate"
              class="form-control"
              placeholder="birthdate"
              v-model="user.birthdate"
              required
            />
          </div>
        </div>
        <div class="clearfix">
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Create Account
          </button>
        </div>
        
        <router-link :to="{ name: 'login' }">Have an account?</router-link>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-register {
  background-color: #f2f2f2;
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 66rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
}

input[type="text"],
input[type="password"],
input[type="date"] {
  width: 80%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type="text"]:focus,
input[type="password"]:focus {
  background-color: #ddd;
  outline: none;
}



button {
  background-color: #04aa6d;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 95%;
  opacity: 0.9;
}

button:hover {
  opacity: 1;
}
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}
#birthdate{
  padding: 1rem;
}
</style>
