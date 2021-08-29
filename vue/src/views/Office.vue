<template>
  <div id="office" class="office">
    <office-title v-if="office" v-bind:officeTitle="office.officeName" />
    <div class="doctorImage">
      <img src="../assets/doctors_talking.jpg" alt="Clinic Building" />
    </div>

    <div class="appointmentTimes">
      <router-link
        v-bind:to="{ name: 'calendar', params: { office_id: officeId } }"
        >View Available Appointment Times</router-link
      >
    </div>
    <office-details v-if="office" v-bind:office="office" />
    <update-office-form v-if="office" v-bind:office="office" />
  </div>
</template>

<script>
import OfficeTitle from "@/components/office/OfficeTitle";
import OfficeDetails from "@/components/office/OfficeDetails";
import UpdateOfficeForm from "@/components/office/UpdateOfficeForm";
export default {
  name: "office",
  components: {
    OfficeTitle,
    OfficeDetails,
    UpdateOfficeForm,
  },
  computed: {
    office() {
      return this.$store.state.offices.find(
        (office) => office.officeId == this.officeId
      );
    },
    officeId() {
      return this.$route.params.office_id;
    },
  },
};
</script>

<style scoped>
.appointmentTimes {
  display: inline-block;
  padding: 0.5rem 1rem;
  border-radius: 30px;
  background-color: rgb(251, 251, 251);
  
  margin: 0;
  position: absolute;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  
}
.office-title {
  grid-area: title;
  text-align: center;
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 58rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
}

img {
  grid-area: photo;
  border-radius: 10px;

  margin-left: auto;
  margin-right: auto;
  height: auto;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

.office ul {
  grid-area: details;
  list-style-type: none;
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

template {
  display: grid;
  grid-template-columns: 0.75fr 1fr;
  grid-template-areas:
    "title title"
    "photo details";
}
</style>