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
        <el-form-item  v-if="type!='info'"  label="医院名称" prop="yiyuanmingcheng">
          <el-input v-model="ruleForm.yiyuanmingcheng" 
              placeholder="医院名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yiyuanmingcheng" label="医院名称" prop="yiyuanmingcheng">
              <el-input v-model="ruleForm.yiyuanmingcheng" 
                placeholder="医院名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="工号" prop="gonghao">
          <el-select  @change="gonghaoChange" v-model="ruleForm.gonghao" placeholder="请选择工号">
            <el-option
                v-for="(item,index) in gonghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gonghao" label="工号" prop="gonghao">
              <el-input v-model="ruleForm.gonghao" 
                placeholder="工号" readonly></el-input>
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
        <el-form-item  v-if="type!='info'"  label="科室" prop="keshi">
          <el-input v-model="ruleForm.keshi" 
              placeholder="科室" clearable></el-input>
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
        <el-form-item v-if="type!='info'" label="预约时间" prop="yuyueshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.yuyueshijian" 
                type="datetime"
                placeholder="预约时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yuyueshijian" label="预约时间" prop="yuyueshijian">
              <el-input v-model="ruleForm.yuyueshijian" 
                placeholder="预约时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingming" label="姓名" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shouji" label="手机" prop="shouji">
              <el-input v-model="ruleForm.shouji" 
                placeholder="手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                              </el-row>
                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'" label="病情情况" prop="bingqingqingkuang">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="病情情况"
                  v-model="ruleForm.bingqingqingkuang">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.bingqingqingkuang" label="病情情况" prop="bingqingqingkuang">
                    <span>{{ruleForm.bingqingqingkuang}}</span>
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
                                yiyuanmingcheng: '',
                                gonghao: '',
                                yishengxingming: '',
                                keshi: '',
                                feiyong: '',
                                bingqingqingkuang: '',
                                yuyueshijian: '',
                                yonghuming: '',
                                xingming: '',
                                shouji: '',
                                sfsh: '',
                                shhf: '',
                                ispay: '',
                      },
                                                    gonghaoOptions: [],
                                                                                                                                                                              rules: {
                  bianhao: [
                                                                                              ],
                  yiyuanmingcheng: [
                                                                                              ],
                  gonghao: [
                            { required: true, message: '工号不能为空', trigger: 'blur' },
                                                                                              ],
                  yishengxingming: [
                                                                                              ],
                  keshi: [
                                                                                              ],
                  feiyong: [
                                                                                              ],
                  bingqingqingkuang: [
                                                                                              ],
                  yuyueshijian: [
                                                                                              ],
                  yonghuming: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  shouji: [
                                                                                              ],
                  sfsh: [
                                                                                              ],
                  shhf: [
                                                                                              ],
                  ispay: [
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
                    if(o=='yiyuanmingcheng'){
            this.ruleForm.yiyuanmingcheng = obj[o];
            continue;
          }
                    if(o=='gonghao'){
            this.ruleForm.gonghao = obj[o];
            continue;
          }
                    if(o=='yishengxingming'){
            this.ruleForm.yishengxingming = obj[o];
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
                    if(o=='bingqingqingkuang'){
            this.ruleForm.bingqingqingkuang = obj[o];
            continue;
          }
                    if(o=='yuyueshijian'){
            this.ruleForm.yuyueshijian = obj[o];
            continue;
          }
                    if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
            continue;
          }
                    if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
            continue;
          }
                    if(o=='shouji'){
            this.ruleForm.shouji = obj[o];
            continue;
          }
                    if(o=='sfsh'){
            this.ruleForm.sfsh = obj[o];
            continue;
          }
                    if(o=='shhf'){
            this.ruleForm.shhf = obj[o];
            continue;
          }
                    if(o=='ispay'){
            this.ruleForm.ispay = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                                                    this.ruleForm.yonghuming = json.yonghuming
                                                this.ruleForm.xingming = json.xingming
                                                this.ruleForm.shouji = json.shouji
                                                                                                } else {
          this.$message.error(data.msg);
        }
      });
                                                                              this.$http({
              url: `option/yisheng/gonghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.gonghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
                                                                                                                                                                                                                                  },
                            // 下二随
    gonghaoChange () {
      this.$http({
        url: `follow/yisheng/gonghao?columnValue=`+ this.ruleForm.gonghao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
                                                                                                      if(data.data.yishengxingming){
                this.ruleForm.yishengxingming = data.data.yishengxingming
              }
                                                if(data.data.keshi){
                this.ruleForm.keshi = data.data.keshi
              }
                                                if(data.data.feiyong){
                this.ruleForm.feiyong = data.data.feiyong
              }
                                                                                                                                                                                                              } else {
          this.$message.error(data.msg);
        }
      });
    },
                                                                                                    // 多级联动参数
                                                                                                                                                        info(id) {
      this.$http({
        url: `yuyuexinxi/info/${id}`,
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
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yuyuexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
      this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
