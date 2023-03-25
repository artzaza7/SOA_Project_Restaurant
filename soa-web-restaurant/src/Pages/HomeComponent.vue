
<script setup>
import MenuCard from '../components/MenuCard.vue'
</script>

<template>
  <div class="row justify-content-between">
    <h3>Course</h3>
    <div class="col">
        <MenuCard msg="Course"/>
    </div>
    <div class="col">
        <MenuCard msg="Course"/>
    </div>
    <div class="col">
        <MenuCard msg="Course"/>
    </div>
    <div class="col">
        <MenuCard msg="Course" />
    </div>
  </div>

  <div class="row justify-content-between mt-3">
    <h3>Menu</h3>
    <div class="col">
        <MenuCard msg="Steak"/>
    </div>
    <div class="col">
        <MenuCard msg="Steak"/>
    </div>
    <div class="col">
        <MenuCard msg="Steak"/>
    </div>
    <div class="col">
        <MenuCard msg="Steak"/>
    </div>
  </div>

  <div class="row justify-content-between mt-3">
    <h3>Type</h3>
    <div class="col">
        <MenuCard msg="main"/>
    </div>
    <div class="col">
        <MenuCard msg="dessert"/>
    </div>
    <div class="col">
        <MenuCard />
    </div>
    <div class="col">
        <MenuCard/>
    </div>
  </div>
  
</template>
