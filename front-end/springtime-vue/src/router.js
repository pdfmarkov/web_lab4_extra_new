import Vue from 'vue'
import VueRouter from 'vue-router'
import start from "@/components/temp_views/start";
import registration from "@/components/temp_views/registration";
import error_container from "@/components/temp_views/error_container";

Vue.use(VueRouter);

export default new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'default-page',
            component: registration,
            beforeEnter: (to, from, next) => {next({name: 'auth-page'})}
        },
        {
            path: '/~s284693/index.html',
            name: 'default-page',
            component: registration,
            beforeEnter: (to, from, next) => {next({name: 'auth-page'})}
        },
        {
            path: '/auth',
            name: 'auth-page',
            component: registration,
        },
        {
            path: '/app',
            name: 'app-page',
            component: start,
        },
        {
            path: '/*',
            name: 'error-page',
            component: error_container,
            props: {
                default: true,
                errorCode: "404",
                errorMessage: "Данной страницы не сущуствует. Повторите авторизацию!"
            }
        },
        {
            path: '/error',
            name: 'error-page-app',
            component: error_container,
            props: {
                default: true,
                errorCode: "401",
                errorMessage: "У вас нет доступа к приложению. Сначала авторизуйтесь!"
            }
        }
    ]
});