<template>
  <body>
    <div id="main">
      <article>
        
        <office-list> </office-list>
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
import OfficeList from "@/components/OfficeList.vue";
import FooterCard from "@/components/layout/FooterCard.vue"
export default {
  computed: {},
  components: {
    DatePicker,
    SlotList,
    OfficeList,
    FooterCard
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
  background:  rgb( 202,240,248);
  order: 3;
  
}
#main > aside {
  background: rgb( 173,232,244);
  order: 2;
}

article,
nav,
aside {
  padding: 1em;
}
</style>

