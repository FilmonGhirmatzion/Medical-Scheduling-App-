<template>
  <body>
    <div id="main">
      <article>
        
        <div id="officeOne" class="officeOne">
          <office-title v-if="office" v-bind:officeTitle="office.officeName" />
        </div>
        <div class="doctorImage">
          <img src="../assets/clinic.jpg" alt="Clinic Building" />
        </div>
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

      </article>
      <nav>
        
        <slot-list></slot-list>
      </nav>
      <aside>
        
        <div id="datePicker" class="column">
          <date-picker v-model="$store.state.selectedDate" />
        </div>
      </aside>
    </div>
    <footer>
      
      <footer-card></footer-card>
    </footer>
  </body>
</template> 

<script>
import DatePicker from "@/components/appointment/DatePicker.vue";
import SlotList from "@/components/appointment/SlotList.vue";
import OfficeTitle from "@/components/office/OfficeTitle";
import FooterCard from "@/components/layout/FooterCard.vue";

export default {
  name: "office",
  props: ["officeOne"],
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
  components: {
    DatePicker,
    SlotList,
    OfficeTitle,
    FooterCard,
    
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}
body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
#main {
  display: flex;
  flex: 1;
}
#main > article {
  flex: 1;
  order: 1;
}
#main > nav,
#main > aside {
  flex: 0 0 20vw;
  margin-top: 0;
}
#main > nav {
  background: rgb(202, 240, 248);
  order: 3;
}
#main > aside {
  background: rgb(173, 232, 244);
  order: 2;
}

article,
nav,
aside {
  padding: 1em;
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
  width: 74%;
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
#detailsAddress {
  background-color: #f2f2f2;
  margin-top: 20px;
  margin: 2rem auto;
  max-width: 58rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  font-size: 20px;
  list-style-type: none;
}
</style>

