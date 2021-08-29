

<template>
  <v-app>
    <ul id="nav">
      <li>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </li>
      <li>
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout
        </router-link>
      </li>
      <li>
        <router-link v-bind:to="{ name: 'offices' }"> Offices</router-link>
      </li>
      <li>
        <router-link v-bind:to="{ name: 'calendar' }">
          Appointments
        </router-link>
      </li>
    </ul>

    <!-- <div id="title-banner">
          <img src="./assets/imageLogo.png" class="center" id="logo"/>
    </div> -->
    <v-main>
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import OfficeService from "./services/OfficeService";
export default {
  created() {
    OfficeService.listOffices().then((response) => {
      const officesList = Array.from(response.data);
      this.$store.commit("SET_OFFICES_LIST", officesList);
    });
    OfficeService.listAppointments().then((response) => {
      const appointmentsList = Array.from(response.data);
      this.$store.commit("SET_APPOINTMENTS_LIST", appointmentsList);
    });
  },
};
</script>
<style >
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap");

#app {
  font-family: "Noto Sans", sans-serif;
  background-color: rgb(224, 229, 238);
  box-sizing: content-box;
}

#nav {
  font-size: 1.5em;
  background-color: rgb(216, 225, 241);
  padding: 0.25em;
  margin-left: 0.25;
  margin-right: 0.25;
}

#nav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: rgb(131, 159, 199);
}

#nav li {
  float: left;
}

#nav li a {
  display: block;
  color: white;
  text-align: center;
  font-size: 1.25em;
  padding: 14px 30px;
  text-decoration: none;
}

#nav li a:hover {
  background-color: rgb(76, 96, 209);
}

#nav li .active {
  background-color: #04aa6d;
}
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 19%;
}


</style>
