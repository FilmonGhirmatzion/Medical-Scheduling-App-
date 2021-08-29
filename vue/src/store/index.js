import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
//import moment from 'vue-moment'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    userRole: '',
    offices: [],
    appointments: [],
    selectedDate: '2021-08-13',
    officeAppointments: [],
    selectedAppointmentTime: ''
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_OFFICES_LIST(state, offices) {
      state.offices = offices;
    },

    SET_APPOINTMENTS_LIST(state, appointments) {
      state.appointments = appointments;

    },
    SET_SELECTED_DATE(state, date) {
      state.selectedDate = date;
    },
    SET_OFFICE_APPOINTMENTS(state, appointments) {
      state.officeAppointments = appointments;
    },
    SET_SELECTED_APPOINTMENT_TIME(state, time) {
      state.selectedAppointmentTime = time;
    },
    DESELECT_APPOINTMENT_TIME(state) {
      state.selectedAppointmentTime = "";
    },
    SET_USER_ROLE(state, role) {
      if (currentUser != null) {
        currentUser.authorities[0].name = role;
      }
    }
  },
  actions: {

  }
})
