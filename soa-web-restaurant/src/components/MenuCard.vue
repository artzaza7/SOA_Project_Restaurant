<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
};
</script>
<template>
  <div class="card" style="width: 100%">
    <img
      class="card-img-top"
      src="https://cdn.eatigo.com/filters:format(webp)/eatigo_dd7b5b79948e4b32ca3c9cae4aee43ec_20180103122415_1920.jpg"
      alt="Card image cap"
    />
    <div class="card-body">
      <div class="row">
        <div class="col">
          <h5 class="card-title">
            {{ msg }}
          </h5>
          <p class="card-text">Steak</p>
        </div>
        <div class="col-4">
          <router-link to="/reservation"  class="btn btn-warning" >จอง</router-link>
        </div>
      </div>
    </div>
  </div>
</template>
