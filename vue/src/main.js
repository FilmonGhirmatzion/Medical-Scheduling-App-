import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import vuetify from './plugins/vuetify'
import TextareaAutosize from 'vue-textarea-autosize'
Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;
Vue.use(TextareaAutosize)
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
