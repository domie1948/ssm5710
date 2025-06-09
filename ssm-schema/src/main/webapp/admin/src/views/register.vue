<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">疫情期间医院门诊管理系统注册</h1>
                              <el-form-item v-if="tableName=='yonghu'" label="用户名" prop="yonghuyonghuming">
        <el-input v-model="ruleForm.yonghuming" placeholder="用户名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="密码" prop="yonghumima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="姓名" prop="yonghuxingming">
        <el-input v-model="ruleForm.xingming" placeholder="姓名"></el-input>
      </el-form-item>
                                                            <el-form-item v-if="tableName=='yonghu'" label="身份证" prop="yonghushenfenzheng">
        <el-input v-model="ruleForm.shenfenzheng" placeholder="身份证"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="手机" prop="yonghushouji">
        <el-input v-model="ruleForm.shouji" placeholder="手机"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yonghu'" label="住址" prop="yonghuzhuzhi">
        <el-input v-model="ruleForm.zhuzhi" placeholder="住址"></el-input>
      </el-form-item>
                                                <el-form-item v-if="tableName=='yisheng'" label="工号" prop="yishenggonghao">
        <el-input v-model="ruleForm.gonghao" placeholder="工号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yisheng'" label="密码" prop="yishengmima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yisheng'" label="医生姓名" prop="yishengyishengxingming">
        <el-input v-model="ruleForm.yishengxingming" placeholder="医生姓名"></el-input>
      </el-form-item>
                                                                              <el-form-item v-if="tableName=='yisheng'" label="费用" prop="yishengfeiyong">
        <el-input v-model="ruleForm.feiyong" placeholder="费用"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yisheng'" label="工作时间" prop="yishenggongzuoshijian">
        <el-input v-model="ruleForm.gongzuoshijian" placeholder="工作时间"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yisheng'" label="身份证" prop="yishengshenfenzheng">
        <el-input v-model="ruleForm.shenfenzheng" placeholder="身份证"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yisheng'" label="电话" prop="yishengdianhua">
        <el-input v-model="ruleForm.dianhua" placeholder="电话"></el-input>
      </el-form-item>
                                                                                                                                                                              <el-button @click="login()" class="btn-login" type="primary">注册</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                              if((!this.ruleForm.yonghuming) && `yonghu` == this.tableName){
        this.$message.error(`用户名不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `yonghu` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                                                                                                                                                                                          if(`yonghu` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入电话格式`);
        return
      }
                                                                                                                  if((!this.ruleForm.gonghao) && `yisheng` == this.tableName){
        this.$message.error(`工号不能为空`);
        return
      }
                                                            if((!this.ruleForm.mima) && `yisheng` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
                                                                                                                                                                                                                                                                  if(`yisheng` == this.tableName && this.ruleForm.feiyong&&(!this.$validate.isIntNumer(this.ruleForm.feiyong))){
        this.$message.error(`费用应输入整数`);
        return
      }
                                                                                                                                    if(`yisheng` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                if(`yisheng` == this.tableName && this.ruleForm.dianhua&&(!this.$validate.isMobile(this.ruleForm.dianhua))){
        this.$message.error(`电话应输入电话格式`);
        return
      }
                                                                                                                                                                                                this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
