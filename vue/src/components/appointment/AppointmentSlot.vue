<template>
  <div id="AppointmentSlot" @click="selectThisTime" v-bind:class="{'selected': isSelected}">
    <button>{{ time }}</button>
  </div>
</template>

<script>
export default {
  name: "time-slot",
  props: ["time"],
  data(){
    return{
   //   date: this.$store.state.date,
    }
  },
  computed: {
    // date(){
    //   return this.$store.state.date;
    // },
    isSelected() {
      return this.time === this.$store.state.selectedAppointmentTime;
    }
  },
  methods: {
    selectThisTime() {
      this.$store.commit("SET_SELECTED_APPOINTMENT_TIME", this.time)
    }
  }
};
</script>

<style scoped>

.selected {
  border-width: 2px;
  border-color: steelblue;
  border-style: solid;
}


</style>