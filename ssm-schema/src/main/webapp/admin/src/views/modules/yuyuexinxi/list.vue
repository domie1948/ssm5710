<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                                              <el-form-item label="医院名称">
                <el-input v-model="searchForm.yiyuanmingcheng" 
                    placeholder="医院名称" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="工号">
                <el-input v-model="searchForm.gonghao" 
                    placeholder="工号" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="医生姓名">
                <el-input v-model="searchForm.yishengxingming" 
                    placeholder="医生姓名" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="科室">
                <el-input v-model="searchForm.keshi" 
                    placeholder="科室" clearable></el-input>
              </el-form-item>
                                                                                                                                                                                                        <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('yuyuexinxi','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('yuyuexinxi','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('yuyuexinxi','查看')"
            :data="dataList"
            border
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler"
            style="width: 100%;">
            <el-table-column
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
                                            <el-table-column
                    prop="bianhao"
                    header-align="center"
                    align="center"
                    sortable
                    label="编号">
                    <template slot-scope="scope">
                      {{scope.row.bianhao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yiyuanmingcheng"
                    header-align="center"
                    align="center"
                    sortable
                    label="医院名称">
                    <template slot-scope="scope">
                      {{scope.row.yiyuanmingcheng}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="gonghao"
                    header-align="center"
                    align="center"
                    sortable
                    label="工号">
                    <template slot-scope="scope">
                      {{scope.row.gonghao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yishengxingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="医生姓名">
                    <template slot-scope="scope">
                      {{scope.row.yishengxingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="keshi"
                    header-align="center"
                    align="center"
                    sortable
                    label="科室">
                    <template slot-scope="scope">
                      {{scope.row.keshi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="feiyong"
                    header-align="center"
                    align="center"
                    sortable
                    label="费用">
                    <template slot-scope="scope">
                      {{scope.row.feiyong}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="bingqingqingkuang"
                    header-align="center"
                    align="center"
                    sortable
                    label="病情情况">
                    <template slot-scope="scope">
                      {{scope.row.bingqingqingkuang}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yuyueshijian"
                    header-align="center"
                    align="center"
                    sortable
                    label="预约时间">
                    <template slot-scope="scope">
                      {{scope.row.yuyueshijian}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yonghuming"
                    header-align="center"
                    align="center"
                    sortable
                    label="用户名">
                    <template slot-scope="scope">
                      {{scope.row.yonghuming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="xingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="姓名">
                    <template slot-scope="scope">
                      {{scope.row.xingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="shouji"
                    header-align="center"
                    align="center"
                    sortable
                    label="手机">
                    <template slot-scope="scope">
                      {{scope.row.shouji}}
                    </template>
                </el-table-column>
                                                                                                                                                    <el-table-column
                  prop="ispay"
                  header-align="center"
                  align="center"
                  sortable
                  label="是否支付">
                  <template slot-scope="scope">
                    <span style="margin-right:10px">{{scope.row.ispay=='已支付'?'已支付':'未支付'}}</span>
                    <el-button v-if="scope.row.ispay!='已支付' && isAuth('yuyuexinxi','支付') " type="text" icon="el-icon-edit" size="small" @click="payHandler(scope.row)">支付</el-button>
                  </template>
                </el-table-column>
                                                      <el-table-column
                  prop="shhf"
                  header-align="center"
                  align="center"
                  sortable
                  label="审核回复">
              </el-table-column>
              <el-table-column
                  v-if="isAuth('yuyuexinxi','审核')"
                  prop="sfsh"
                  header-align="center"
                  align="center"
                  sortable
                  label="审核">
                  <template slot-scope="scope">
                    <span style="margin-right:10px">{{scope.row.sfsh=='是'?'通过':'未通过'}}</span>
                    <el-button  type="text" icon="el-icon-edit" size="small" @click="shDialog(scope.row)">审核</el-button>
                  </template>
              </el-table-column>
                        <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('yuyuexinxi','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                <el-button v-if="isAuth('yuyuexinxi','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('yuyuexinxi','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
                                                                                                                                                                                                                                                <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

    
        <el-dialog
      title="审核"
      :visible.sync="sfshVisiable"
      width="50%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="审核状态">
          <el-select v-model="shForm.sfsh" placeholder="审核状态">
            <el-option label="通过" value="是"></el-option>
            <el-option label="不通过" value="否"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="shDialog">取 消</el-button>
        <el-button type="primary" @click="shHandler">确 定</el-button>
      </span>
    </el-dialog>
    
      </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
                                                                              gonghaoOptions: [],
                                                                                                                                                                                                                                                      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
          };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
      },
  methods: {
            payHandler(row){
      this.$storage.set('paytable','yuyuexinxi');
      this.$storage.set('payObject',row);
      this.$router.push('pay');
    },
            init () {
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
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                                                if(this.searchForm.yiyuanmingcheng!='' && this.searchForm.yiyuanmingcheng!=undefined){
            params['yiyuanmingcheng'] = '%' + this.searchForm.yiyuanmingcheng + '%'
          }
                                                            if(this.searchForm.gonghao!='' && this.searchForm.gonghao!=undefined){
            params['gonghao'] = '%' + this.searchForm.gonghao + '%'
          }
                                                            if(this.searchForm.yishengxingming!='' && this.searchForm.yishengxingming!=undefined){
            params['yishengxingming'] = '%' + this.searchForm.yishengxingming + '%'
          }
                                                            if(this.searchForm.keshi!='' && this.searchForm.keshi!=undefined){
            params['keshi'] = '%' + this.searchForm.keshi + '%'
          }
                                                                                                                                                                                                                                    this.$http({
        url: "yuyuexinxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
        // 审核窗口
    shDialog(row){
      this.sfshVisiable = !this.sfshVisiable;
      if(row){
        this.shForm = {
                    bianhao: row.bianhao,
                    yiyuanmingcheng: row.yiyuanmingcheng,
                    gonghao: row.gonghao,
                    yishengxingming: row.yishengxingming,
                    keshi: row.keshi,
                    feiyong: row.feiyong,
                    bingqingqingkuang: row.bingqingqingkuang,
                    yuyueshijian: row.yuyueshijian,
                    yonghuming: row.yonghuming,
                    xingming: row.xingming,
                    shouji: row.shouji,
                    sfsh: row.sfsh,
                    shhf: row.shhf,
                    ispay: row.ispay,
                    id: row.id
        }
      }
    },
    // 审核
    shHandler(){
      this.$confirm(`确定操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuyuexinxi/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuyuexinxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
