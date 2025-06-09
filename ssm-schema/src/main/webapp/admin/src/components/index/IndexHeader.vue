<template>
	<el-header>
		<el-menu mode="horizontal">
			<img class="logo fl" src="@/assets/img/logo.png" alt>
			<div class="fl title">{{this.$project.projectName}}</div>
			<el-menu-item class="fr" @click="onLogout" index="2">
				<div>退出登录</div>
			</el-menu-item>
      <el-menu-item  @click="onIndexTap" class="fr" index="4">
				<div>退出到首页</div>
			</el-menu-item>
			<el-menu-item class="fr" index="3">
				<div>{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			</el-menu-item>
			
		<!-- <el-menu-item @click="onLogout" class="fr" index="3">退出登陆</el-menu-item> -->
		</el-menu>
	</el-header>
</template>

<script>
export default {
  methods:{
    onLogout(){
      // this.$storage.remove('token');
      this.$storage.remove('Token');
      this.$router.replace({ name: "login" });
    },
    onIndexTap(){
      window.location.href = `${this.$base.indexUrl}`
    }
  }
};
</script>


<style lang="scss" scoped>
.el-header .fr {
  float: right;
}
.el-header .fl {
  float: left;
}
.el-header {
  width: 100%;
  color: #333;
  text-align: center;
  line-height: 60px;
  padding: 0;
  z-index: 99;
}
.logo {
  width: 60px;
  height: 60px;
  margin-left: 70px;
}
</style>
