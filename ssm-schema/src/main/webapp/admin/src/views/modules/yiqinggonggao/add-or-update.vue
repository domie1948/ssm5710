<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item v-if="type!='info'" label="编号" prop="bianhao">
            <el-input v-model="ruleForm.bianhao" 
                placeholder="编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.bianhao" label="编号" prop="bianhao">
              <el-input v-model="ruleForm.bianhao" 
                placeholder="编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="标题" prop="biaoti">
          <el-input v-model="ruleForm.biaoti" 
              placeholder="标题" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.biaoti" label="标题" prop="biaoti">
              <el-input v-model="ruleForm.biaoti" 
                placeholder="标题" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="发布日期" prop="faburiqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.faburiqi" 
                type="date"
                placeholder="发布日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.faburiqi" label="发布日期" prop="faburiqi">
              <el-input v-model="ruleForm.faburiqi" 
                placeholder="发布日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                  <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="内容" prop="neirong">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="内容"
                  v-model="ruleForm.neirong">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.neirong" label="内容" prop="neirong">
                    <span>{{ruleForm.neirong}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                              <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
            ruleForm: {
                        bianhao: this.getUUID(),
                                biaoti: '',
                                tupian: '',
                                neirong: '',
                                faburiqi: '',
                      },
                                                                                  rules: {
                  bianhao: [
                                                                                              ],
                  biaoti: [
                            { required: true, message: '标题不能为空', trigger: 'blur' },
                                                                                              ],
                  tupian: [
                                                                                              ],
                  neirong: [
                                                                                              ],
                  faburiqi: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='bianhao'){
            this.ruleForm.bianhao = obj[o];
            continue;
          }
                    if(o=='biaoti'){
            this.ruleForm.biaoti = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='neirong'){
            this.ruleForm.neirong = obj[o];
            continue;
          }
                    if(o=='faburiqi'){
            this.ruleForm.faburiqi = obj[o];
            continue;
          }
                  }
                                                                                              }
                                                                                                                        },
                                                // 多级联动参数
                                                              info(id) {
      this.$http({
        url: `yiqinggonggao/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                              this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yiqinggonggao/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.yiqinggonggaoCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yiqinggonggaoCrossAddOrUpdateFlag = false;
    },
                                                tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
            },
                                      }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
</style>
