<template>
  <div id="booking-buttons">
    <button id="book-appointment" type="submit" @click="bookAppointment">Book Appointment</button>
    <button id="cancel" type="reset" @click="deselectAppointmentTime">Cancel</button>
  </div>
</template>

<script>
import OfficeService from "@/services/OfficeService.js";
export default {
  name: "booking-buttons",
  methods: {
    deselectAppointmentTime() {
      this.$store.commit("DESELECT_APPOINTMENT_TIME");
      alert("cancel");
    },
    bookAppointment() {
        const time = this.$store.state.selectedAppointmentTime;
        const date = this.$store.state.selectedDate;
        const officeId = this.$route.params.office_id;
        OfficeService.createAppointment(time, date, officeId);
        alert(`Create ${time} ${date} at Office ${officeId}`);
    },
  },

};
</script>

<style scoped>
#book-appointment, #cancel {
  display: inline-block;
  padding: 0.5rem 1rem;
  border-radius: 30px;
  background-color: rgb(251, 251, 251);
}

</style>