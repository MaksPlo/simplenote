import Vue from 'vue'
import VueResource from 'vue-resource'
import Vuetify from 'vuetify'
import App from 'pages/App.vue'
import 'vuetify/dist/vuetify.min.css'
import moment from "moment";


Vue.use(Vuetify)
Vue.use(VueResource)

Vue.filter('formatDate', function (value) {
    if (value) {
        return moment(String(value)).format('hh:mm MM/DD/YYYY')
    }
})


new Vue({
    el: '#app',
    render: a => a(App)
})

