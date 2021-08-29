<template>
<section>
  <div id="slot-list" class="col justify-center">
    <appointment-slot
      v-for="time in times"
      :key="time"
      v-bind:time="time"
      v-bind:class="isAppointmentTime(time) ? 'unavailable' : 'available'" 
    />
  </div>
</section>
  
</template>

<script>
import AppointmentSlot from "@/components/appointment/AppointmentSlot.vue";

export default {
  name: "slot-list",
  data() {
    return {
      times: [
        "8:00",
        "9:00",
        "10:00",
        "11:00",
        "12:00",
        "1:00",
        "2:00",
        "3:00",
        "4:00",
        "5:00",
        "6:00",
      ],
    };
  },
  components: {
    AppointmentSlot,
  },
  computed: {
    appointmentTimes() {
      const appointmentTimes = [];
      this.$store.state.officeAppointments.forEach((element) => {
        appointmentTimes.push(element.appointmentTime);
      });

      return appointmentTimes;
    },
  },
  methods: {
    isAppointmentTime(time) {
      const output = this.$store.state.officeAppointments.find(
        (appointment) =>
          this.formatTime(appointment.appointmentTime) === time &&
          appointment.appointmentDate == this.$store.state.selectedDate
      );
      return output;
    },
    formatTime(time) {
      const endIndex = time.length - 3;
      const beginingIndex = time.charAt(0) === "0" ? 1 : 0;
      return time.substring(beginingIndex, endIndex);
    },
  },
};
</script>

<style scoped>
#slot-list {
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 16rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  text-align: center;
  font-size: 20px;
}

#MeetingSlots {
  width: 290px;
  text-align: center;
  padding: 10px;
  margin: auto;
}

.unavailable {
  background-color: rgb(120, 184, 226);
}
.available {
  background-color: rgb(255, 255, 255);
}

#MeetingSlots:hover {
  background-color: rgb(243, 243, 243);
}
</style>