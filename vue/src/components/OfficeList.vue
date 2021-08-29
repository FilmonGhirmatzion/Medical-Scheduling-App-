<template>
  <div id="officeList">
    <section>
      <img src="../assets/mapofLocations.png" class="center" />
    </section>
    <div id="intro">
        <h3>Find Your New Primary Care Provider</h3>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
        veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
        commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
        velit esse cillum dolore eu fugiat nulla pariatur.
      </p>
    </div>
    <ul id="listOfOffices">
      <p id="list">List Of Offices</p>
      <office-list-item
        v-for="office in $store.state.offices"
        v-bind:key="office.officeId"
        v-bind:office="office"
      />
    </ul>
  </div>
</template>

<script>
import OfficeListItem from "@/components/OfficeListItem.vue";
export default {
  components: {
    OfficeListItem,
  },
};
</script>

<style scoped>
#intro,
#listOfOffices {
  background-color: #f2f2f2;
  margin-top: 20px;
  margin-left: 20px;
  margin-right: 20px;
  margin: 2rem auto;
  max-width: 58rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
  list-style-type: none;
}
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
#list {
  font-size: 1.2em;
  font-weight: bold;
}
</style>