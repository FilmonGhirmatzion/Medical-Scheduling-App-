import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080"
  });


  export default {

    getCalendar(doctorId){
        return http.get(`/doctors/${doctorId}/calendar`);
    },

   



  }