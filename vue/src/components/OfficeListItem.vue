<template>
  <div id="officeListItem">
    <li>
      <router-link
        v-bind:to="{ name: 'office', params: { office_id: office.officeId } }"
      >
        {{ office.officeName }}
      </router-link>
    </li>
  </div>
</template>

<script>
export default {
  name: "office-list-item",
  props: ["office"],
};
</script>

<style scoped>
</style>