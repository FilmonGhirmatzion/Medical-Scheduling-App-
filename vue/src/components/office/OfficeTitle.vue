
<template>

  <header id="office-title" class="office-title" >
      {{ officeTitle }}
  </header>
</template>

<script>
export default {
  name: 'office-title',
  props: ['officeTitle']
}
</script>

<style scoped >

.office-title {
  font-size: 20px;
  margin: 0.75em;
  background-color: #f2f2f2;
}

</style>