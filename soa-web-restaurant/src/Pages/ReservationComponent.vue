<template>
  <div class="row justify-content-center">
    
    <div class="col"></div>
    <div class="col">
      <h4 class="mb-3">Reservation_id : Variable</h4>
    <h4 class="mb-3">User_id : Variable</h4>
      <h4 class="mb-3">Select Table</h4>
      <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
        <option selected>Select Table</option>
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
      </select>
      <h4>Select Course</h4>
      <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
        <option selected>Select Course</option>
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
      </select>
      <div class="row justify-content-between">
        <div class="col-4 ">
        <button type="submit" class="btn btn-success">Save</button>
      </div><div class="col-4">
        <button type="button" class="btn btn-danger">Cancle</button>
      </div>
      </div>
    </div>
    <div class="col"></div>
  </div>
  
</template>
