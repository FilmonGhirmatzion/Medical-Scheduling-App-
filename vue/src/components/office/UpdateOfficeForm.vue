<template>
  <div id="update-office-form" class="container">
     <h3>To update office info please fill in the form bellow</h3>
    <form id="office-form" v-if="office" v-on:submit.prevent="updateOfficeForm">
      <label for="officeName" class="form">Office Name</label>
      <input
        type="text"
        name="officeName"
        id="office-name"
        required="true"
        v-model="formOffice.officeName"
      />
      <label for="streetAddress">Street Address</label>
      <input
        type="text"
        name="streetAddress"
        id="office-street-address"
        required="true"
        v-model="formOffice.officeStreetAddress"
      />
      <label for="officeCity">City</label>
      <input
        type="text"
        name="officeCity"
        id="office-city"
        required="true"
        v-model="formOffice.officeCity"
      />
      <label for="officeState">State</label>
      <input
        type="text"
        name="officeState"
        id="office-state"
        required="true"
        v-model="formOffice.officeState"
      />
      <label for="officeZip">Zip</label>
      <input
        type="text"
        name="officeZip"
        id="office-zip"
        required="true"
        v-model="formOffice.officeZip"
      />
      <label for="officePhone">Phone</label>
      <input
        type="text"
        name="officePhone"
        id="office-phone"
        required="true"
        v-model="formOffice.officePhone"
      />
      <label for="officeEmail">Email</label>
      <input
        type="email"
        name="officeEmail"
        id="office-email"
        required="true"
        v-model="formOffice.officeEmail"
      />
      <label for="officeHours">Hours</label>
      <input
        type="text"
        name="officeHours"
        id="office-hours"
        required="true"
        v-model="formOffice.officeHours"
      />
      <label for="officeParking">Parking</label>
      <input
        type="text"
        name="officeParking"
        id="office-parking"
        v-model="formOffice.officeParking"
      />
      <label for="additionalInfo">Info</label>
      <input
        type="text"
        name="additionalInfo"
        id="additional-info"
        v-model="formOffice.additionalInfo"
      />
      <label for="officeUrl">Url</label>
      <input
        type="text"
        name="officeUrl"
        id="office-url"
        v-model="formOffice.officeUrl"
      />
      <input type="submit" value="Submit" />
    </form>
  </div>
</template>

<script>
import OfficeService from "@/services/OfficeService";
export default {
  data() {
    return {
      formOffice: this.office,
    };
  },
  props: ["office"],
  name: "update-office-form",

  methods: {
    updateOfficeForm() {
      OfficeService.updateOffice(this.formOffice).then(() => {
        OfficeService.listOffices().then((listResponse) => {
          const officesList = Array.from(listResponse.data);
          this.$store.commit("SET_OFFICES_LIST", officesList);
        });
      });
    },
  },
};
</script>

<style scoped>
#office-form{
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 58rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
}
.container {

  background-color: #f2f2f2;
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 58rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
}
div {
  align-self: start;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input[type="text"],
input[type="email"] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type="submit"] {
  width: 95%;

  background-color: #2f8632;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #45a049;
  
}

@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>