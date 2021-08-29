<template>

  <div id="calendar" class="column">
    <router-link id="office-detail-link" v-bind:to="{ name: 'office', params: { office_id: officeId } }"
      >View Office Details</router-link>

      
    <div id="datePicker" class="column">
      <date-picker v-model="$store.state.selectedDate" />
    </div>

    <slot-list />
    <booking-buttons id="button-container"/>
  </div>
</template>

<script>
import DatePicker from "@/components/appointment/DatePicker.vue";
import SlotList from "@/components/appointment/SlotList.vue";
import OfficeService from "@/services/OfficeService";
import BookingButtons from "@/components/appointment/BookingButtons.vue";
export default {
  data() {
    return {};
  },
  computed: {
    selectedDate() {
      return this.$store.state.selectedDate;
    },
    officeId() {
      return this.$route.params.office_id;
    },
    // officeAppointmentsForSelectedDate() {
    //   return this.$store.state.officeAppointments.filter((appointment) => {
    //     return appointment.appointmentDate == this.$store.state.selectedDate;
    //   });
    // },
  },
  components: {
    DatePicker,
    SlotList,
    BookingButtons
  },
  mounted() {
    OfficeService.getAppointmentsByOffice(this.officeId).then((response) => {
      const appointmentsList = Array.from(response.data);
      this.$store.commit("SET_OFFICE_APPOINTMENTS", appointmentsList);
    });
  },
};
</script>

<style scoped>

#office-detail-link {
  display: inline-block;
  padding: 0.5rem 1rem;
  border-radius: 30px;
  background-color: rgb(251, 251, 251);
}

#button-container {
  text-align: center;
}

#calendar {
  text-align: center;
}

</style>