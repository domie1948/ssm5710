import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/shijuanliebiao/exam'
    import yiyuanxinxi from '@/views/modules/yiyuanxinxi/list'
    import yichangbaogao from '@/views/modules/yichangbaogao/list'
    import lunbotuguanli from '@/views/modules/lunbotuguanli/list'
    import xingdongguiji from '@/views/modules/xingdongguiji/list'
    import zaixianliaotian from '@/views/modules/zaixianliaotian/list'
    import yiyangbaogao from '@/views/modules/yiyangbaogao/list'
    import yuyuexinxi from '@/views/modules/yuyuexinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import keshixinxi from '@/views/modules/keshixinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yiqinggonggao from '@/views/modules/yiqinggonggao/list'
    import liaotianhuifu from '@/views/modules/liaotianhuifu/list'
    import yisheng from '@/views/modules/yisheng/list'

//2.配置路由   注意：名字
const routes = [
    {
        path: '/index', name:'index', component: Index, children: [{
            // 这里不设置值，是把main作为默认页面
            path: '/',
            name: 'home',
            component: Home
        },{
            path: '/updatePassword',
            name: 'updatePassword',
            component: UpdatePassword
        } ,{
            path: '/pay',
            name: 'pay',
            component: pay
        } ,{
            path: '/center',
            name: 'center',
            component: center
        } 
                    ,{
                path: '/yiyuanxinxi',
                name: 'yiyuanxinxi',
                component: yiyuanxinxi
            } 
                    ,{
                path: '/yichangbaogao',
                name: 'yichangbaogao',
                component: yichangbaogao
            } 
                    ,{
                path: '/lunbotuguanli',
                name: 'lunbotuguanli',
                component: lunbotuguanli
            } 
                    ,{
                path: '/xingdongguiji',
                name: 'xingdongguiji',
                component: xingdongguiji
            } 
                    ,{
                path: '/zaixianliaotian',
                name: 'zaixianliaotian',
                component: zaixianliaotian
            } 
                    ,{
                path: '/yiyangbaogao',
                name: 'yiyangbaogao',
                component: yiyangbaogao
            } 
                    ,{
                path: '/yuyuexinxi',
                name: 'yuyuexinxi',
                component: yuyuexinxi
            } 
                    ,{
                path: '/storeup',
                name: 'storeup',
                component: storeup
            } 
                    ,{
                path: '/keshixinxi',
                name: 'keshixinxi',
                component: keshixinxi
            } 
                    ,{
                path: '/yonghu',
                name: 'yonghu',
                component: yonghu
            } 
                    ,{
                path: '/yiqinggonggao',
                name: 'yiqinggonggao',
                component: yiqinggonggao
            } 
                    ,{
                path: '/liaotianhuifu',
                name: 'liaotianhuifu',
                component: liaotianhuifu
            } 
                    ,{
                path: '/yisheng',
                name: 'yisheng',
                component: yisheng
            } 
                ]
    },
    { path: '/adminexam', name: 'adminexam', component: adminexam },
    { path: '/login', name:'login', component: Login },
    { path: '/register', name:'register', component: register },
    { path: '/', redirect: '/index/' },      /*默认跳转路由*/
    { path: '*', component: NotFound }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
    mode: 'hash',   /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;

