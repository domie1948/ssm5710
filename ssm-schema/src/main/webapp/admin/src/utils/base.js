const base = {
    get() {
                return {
            url : "http://localhost:8080/ssm57wsx/",
            name: "ssm57wsx",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm57wsx/front/index.html'
        }
            },
    getProjectName(){
        return {
            projectName: "疫情期间医院门诊管理系统"
        } 
    }
}
export default base