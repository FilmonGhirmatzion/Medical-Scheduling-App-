// officeCity: "Columbus",
//       officeState: "OH",
//       officeZip: 43207,
//       officePhone: "(614) 645-5500",
//       officeEmail: "office@primaryone.com",
//       officeHours: "8AM-5PM",
//       officeParking: "Parking is Free",
//       additionalInfo: "No Additional Info",
//       image_url: null,
//       officeUrl: "https://www.primaryone.com",



<template>
<section id ="detailsAddress">
  <div id="office-details" type="address">
    <li id="address" >
      Address:
      {{ office.officeStreetAddress }}
    </li>
    <li id="office-city-state">
      {{ office.officeCity }}, {{ office.officeState }}
    </li>
    <li id="office-zip">
      {{ office.officeZip }}
    </li>

    <li id="contact-info">Phone: {{ office.officePhone }}</li>
    <li id="office-email">Email: {{ office.officeEmail }}</li>

    <li id="office-hours">Hours: {{ office.officeHours }}</li>
    <li id="office-parking">
      {{ office.officeParking }}
    </li>
    <li id="office-additionalInfo">
      {{ office.additionalInfo }}
    </li>
    <li id="office-officeUrl">
      <a href="">{{ office.officeUrl }}</a>
    </li>
  </div>
</section>
  
</template>

<script>
export default {
  props: ["office"],
};
</script >

<style scoped>

#detailsAddress {
  background-color: #f2f2f2;
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 58rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
}

@media screen and (max-width: 600px) {
  .col-25,
  .col-75,
  input[type="address"] {
    width: 100%;
    margin-top: 0;
  }
}
</style>