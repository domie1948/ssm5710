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
        <el-form-item  v-if="type!='info'"  label="工号" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" 
              placeholder="工号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gonghao" label="工号" prop="gonghao">
              <el-input v-model="ruleForm.gonghao" 
                placeholder="工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="密码" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="密码" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.mima" label="密码" prop="mima">
              <el-input v-model="ruleForm.mima" 
                placeholder="密码" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="医生姓名" prop="yishengxingming">
          <el-input v-model="ruleForm.yishengxingming" 
              placeholder="医生姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yishengxingming" label="医生姓名" prop="yishengxingming">
              <el-input v-model="ruleForm.yishengxingming" 
                placeholder="医生姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in xingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingbie" label="性别" prop="xingbie">
              <el-input v-model="ruleForm.xingbie" 
                placeholder="性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="相片" prop="xiangpian">
          <file-upload
          tip="点击上传相片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.xiangpian?ruleForm.xiangpian:''"
          @change="xiangpianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xiangpian" label="相片" prop="xiangpian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xiangpian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="科室" prop="keshi">
          <el-select v-model="ruleForm.keshi" placeholder="请选择科室">
            <el-option
                v-for="(item,index) in keshiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.keshi" label="科室" prop="keshi">
              <el-input v-model="ruleForm.keshi" 
                placeholder="科室" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="费用" prop="feiyong">
          <el-input v-model="ruleForm.feiyong" 
              placeholder="费用" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.feiyong" label="费用" prop="feiyong">
              <el-input v-model="ruleForm.feiyong" 
                placeholder="费用" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="工作时间" prop="gongzuoshijian">
          <el-input v-model="ruleForm.gongzuoshijian" 
              placeholder="工作时间" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gongzuoshijian" label="工作时间" prop="gongzuoshijian">
              <el-input v-model="ruleForm.gongzuoshijian" 
                placeholder="工作时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="身份证" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shenfenzheng" label="身份证" prop="shenfenzheng">
              <el-input v-model="ruleForm.shenfenzheng" 
                placeholder="身份证" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="电话" prop="dianhua">
          <el-input v-model="ruleForm.dianhua" 
              placeholder="电话" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dianhua" label="电话" prop="dianhua">
              <el-input v-model="ruleForm.dianhua" 
                placeholder="电话" readonly></el-input>
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
                        gonghao: '',
                                mima: '',
                                yishengxingming: '',
                                xingbie: '',
                                xiangpian: '',
                                keshi: '',
                                feiyong: '',
                                gongzuoshijian: '',
                                shenfenzheng: '',
                                dianhua: '',
                      },
                                                                  xingbieOptions: [],
                                              keshiOptions: [],
                                                                            rules: {
                  gonghao: [
                            { required: true, message: '工号不能为空', trigger: 'blur' },
                                                                                              ],
                  mima: [
                            { required: true, message: '密码不能为空', trigger: 'blur' },
                                                                                              ],
                  yishengxingming: [
                                                                                              ],
                  xingbie: [
                                                                                              ],
                  xiangpian: [
                                                                                              ],
                  keshi: [
                                                                                              ],
                  feiyong: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  gongzuoshijian: [
                                                                                              ],
                  shenfenzheng: [
                                                                                        { validator: validateIdCard, trigger: 'blur' },
                                  ],
                  dianhua: [
                                                                { validator: validatePhone, trigger: 'blur' },
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
                    if(o=='gonghao'){
            this.ruleForm.gonghao = obj[o];
            continue;
          }
                    if(o=='mima'){
            this.ruleForm.mima = obj[o];
            continue;
          }
                    if(o=='yishengxingming'){
            this.ruleForm.yishengxingming = obj[o];
            continue;
          }
                    if(o=='xingbie'){
            this.ruleForm.xingbie = obj[o];
            continue;
          }
                    if(o=='xiangpian'){
            this.ruleForm.xiangpian = obj[o];
            continue;
          }
                    if(o=='keshi'){
            this.ruleForm.keshi = obj[o];
            continue;
          }
                    if(o=='feiyong'){
            this.ruleForm.feiyong = obj[o];
            continue;
          }
                    if(o=='gongzuoshijian'){
            this.ruleForm.gongzuoshijian = obj[o];
            continue;
          }
                    if(o=='shenfenzheng'){
            this.ruleForm.shenfenzheng = obj[o];
            continue;
          }
                    if(o=='dianhua'){
            this.ruleForm.dianhua = obj[o];
            continue;
          }
                  }
                                                                                                                                                                              }
                                                                                                this.xingbieOptions = "男,女".split(',')
                                                          this.$http({
              url: `option/keshixinxi/keshi`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.keshiOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                    },
                                                                                        // 多级联动参数
                                                                                                                info(id) {
      this.$http({
        url: `yisheng/info/${id}`,
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
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yisheng/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.yishengCrossAddOrUpdateFlag = false;
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
      this.parent.yishengCrossAddOrUpdateFlag = false;
    },
                                                                        xiangpianUploadChange(fileUrls) {
                this.ruleForm.xiangpian = fileUrls;
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
