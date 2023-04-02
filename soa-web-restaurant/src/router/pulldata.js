
import axios from "axios";
export default {
  data() {
    return {
      info: null,
      table: null,
      course: null,
      menucourse: null,
      menu: null,
      menutype: null
    };
  },
  mounted() {
    axios.get("http://localhost:8081/api/v1/users").then((response) => {
      this.info = response.data;
      console.log(response.data);
    }),
      axios.get("http://localhost:8081/api/v1/tables").then((response) => {
        this.table = response.data;
        console.log(response.data);
      }),
      axios.get("http://localhost:8081/api/v1/coursemenus").then((response) => {
        this.course = response.data;
        console.log(response.data);
      }),
      axios
        .get("http://localhost:8081/api/v1/menus/course/{name}")
        .then((response) => {
          this.menucourse = response.data;
          console.log(response.data);
        }),
        axios
        .get("http://localhost:8081/api/v1/menus")
        .then((response) => {
          this.menu = response.data;
          console.log(response.data);
        }),
        axios
        .get("http://localhost:8081/api/v1/menuType")
        .then((response) => {
          this.menutype = response.data;
          console.log(response.data);
        });
  },
};
