<template>
  <div class = "doctor-view-calander">
  <doctor-calander />
  <appointment />
  </div>
    
</template>

<script>
import DoctorCalander from "../views/Calendar.vue"
import Appointment from "../components/appointment/AppointmentSlot.vue"
export default {

  name:"doctor",
  components:{
    DoctorCalander,
    Appointment

    
  },
  data(){
    return{
      DoctorCalander:[],
      Appointment:[]
      
    };
    
  }

}
</script>

<style>


</style>