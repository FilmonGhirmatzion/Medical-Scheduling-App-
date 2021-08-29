// more information on this here: https://vuetifyjs.com/en/components/date-pickers/#allowed-dates

<template>
  <v-row id="datePicker" justify="center">
    <v-date-picker
      v-model="date"
      class="mt-4"
      @change="selectDate($event)"
    ></v-date-picker>
  </v-row>
</template>

  <script>

  export default {
    name: 'date-picker',
    data: () => ({
      date: "2021-08-13",
    }),

    methods: {
      printEvent(event) {
        console.log(event);
      },
      selectDate(event) {
        this.$store.commit('SET_SELECTED_DATE', event)
      }
      //allowedDates: val => parseInt(val.split('-')[2], 10) % 2 === 0,
    },
  };
</script>
<style  scoped>

</style>