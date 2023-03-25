import { createApp } from 'vue'
import App from './Pages/App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import router from './router'

createApp(App).use(router).mount('#app')
