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
        <el-form-item  v-if="type!='info'"  label="名称" prop="mingcheng">
          <el-input v-model="ruleForm.mingcheng" 
              placeholder="名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.mingcheng" label="名称" prop="mingcheng">
              <el-input v-model="ruleForm.mingcheng" 
                placeholder="名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="出行时间" prop="chuxingshijian">
          <el-input v-model="ruleForm.chuxingshijian" 
              placeholder="出行时间" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chuxingshijian" label="出行时间" prop="chuxingshijian">
              <el-input v-model="ruleForm.chuxingshijian" 
                placeholder="出行时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="现在状况" prop="xianzaizhuangkuang">
          <el-select v-model="ruleForm.xianzaizhuangkuang" placeholder="请选择现在状况">
            <el-option
                v-for="(item,index) in xianzaizhuangkuangOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xianzaizhuangkuang" label="现在状况" prop="xianzaizhuangkuang">
              <el-input v-model="ruleForm.xianzaizhuangkuang" 
                placeholder="现在状况" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="登记日期" prop="dengjiriqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.dengjiriqi" 
                type="date"
                placeholder="登记日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dengjiriqi" label="登记日期" prop="dengjiriqi">
              <el-input v-model="ruleForm.dengjiriqi" 
                placeholder="登记日期" readonly></el-input>
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
              <el-form-item v-if="type!='info'" label="出行地点" prop="chuxingdidian">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="出行地点"
                  v-model="ruleForm.chuxingdidian">
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.chuxingdidian" label="出行地点" prop="chuxingdidian">
                    <span>{{ruleForm.chuxingdidian}}</span>
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
                        mingcheng: '',
                                chuxingdidian: '',
                                chuxingshijian: '',
                                xianzaizhuangkuang: '',
                                dengjiriqi: '',
                                yonghuming: '',
                                xingming: '',
                                shouji: '',
                      },
                                                                  xianzaizhuangkuangOptions: [],
                                                                            rules: {
                  mingcheng: [
                            { required: true, message: '名称不能为空', trigger: 'blur' },
                                                                                              ],
                  chuxingdidian: [
                                                                                              ],
                  chuxingshijian: [
                                                                                              ],
                  xianzaizhuangkuang: [
                                                                                              ],
                  dengjiriqi: [
                                                                                              ],
                  yonghuming: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  shouji: [
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
                    if(o=='mingcheng'){
            this.ruleForm.mingcheng = obj[o];
            continue;
          }
                    if(o=='chuxingdidian'){
            this.ruleForm.chuxingdidian = obj[o];
            continue;
          }
                    if(o=='chuxingshijian'){
            this.ruleForm.chuxingshijian = obj[o];
            continue;
          }
                    if(o=='xianzaizhuangkuang'){
            this.ruleForm.xianzaizhuangkuang = obj[o];
            continue;
          }
                    if(o=='dengjiriqi'){
            this.ruleForm.dengjiriqi = obj[o];
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
                                                                                                this.xianzaizhuangkuangOptions = "良好,一般,差".split(',')
                                                                                                    },
                                                                        // 多级联动参数
                                                                                            info(id) {
      this.$http({
        url: `xingdongguiji/info/${id}`,
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
                                                                                                                                                                                    this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `xingdongguiji/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.xingdongguijiCrossAddOrUpdateFlag = false;
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
      this.parent.xingdongguijiCrossAddOrUpdateFlag = false;
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
