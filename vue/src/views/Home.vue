<template>
  <div id="home" class="home">
    
    <div class="login-register" v-show="!loggedIn">
      <router-link :to="{name:'register'}">Register</router-link>
      <login></login>
    </div>
    <div v-show="loggedIn">
      <router-link :to="{name: 'redirect'}" tag="button">User page</router-link>
    </div>
    <p></p>
    <office-list></office-list>
  </div>
</template> 

<script>
import login from '@/views/Login';

export default {
  name: "home",
  computed: {
    loggedIn() {
      return this.$store.state.token.length > 0;
    }
  },
  components: {
    login, 
    
  },

};
</script>
