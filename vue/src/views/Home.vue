<template>
  <div style="color: #666;font-size: 14px;">
    <div style="padding-bottom: 20px">
      <b>欢迎你！{{ user.nickname }}</b>
    </div>
    <el-card>
      青哥出手，马上拥有
      <el-divider />
      虎虎生威，虎年大吉
    </el-card>
    <div style="height: 1px; background: #ddd; margin: 20px 0"/>

    <el-row :gutter="30">
      <el-col :span="12">
        <div style="padding: 20px 0; font-size: 20px">小白做毕设专用框架</div>
        <div>
          这是一款专门针对毕设系统设计的框架，代码简单，结构清晰，如果你是小白，一定不要错过哦
        </div>
        <div class="m-10"><el-button type="danger"><i class="el-icon-coin"></i> 免费开源</el-button></div>
        <div class="m-10"><el-button type="primary"><i class="el-icon-s-custom"></i> 交流QQ群：529910361</el-button></div>
        <div class="m-10">
          <el-button type="primary"><i class="el-icon-link"></i> <a style="color: #fff" href="https://gitee.com/xqnode/pure-design">Gitee源码</a></el-button>
          <el-button type="primary"><i class="el-icon-link"></i> <a style="color: #fff" href="https://www.bilibili.com/video/BV1U44y1W77D">B站视频讲解</a></el-button>
        </div>
      </el-col>
      <el-col :span="12">
        <div style="padding: 20px 0; font-size: 20px">技术栈</div>
        <el-row>
          <el-col :span="12" style="line-height: 30px">
            <div><b>后端</b></div>
            <div>SpringBoot2</div>
            <div>Hutool</div>
            <div>Poi</div>
            <div>Lombok</div>
            <div>Mybatis/Mybatis-plus</div>
          </el-col>
          <el-col :span="12" style="line-height: 30px">
            <b>前端</b>
            <div>Vue2</div>
            <div>Vue-Router</div>
            <div>VueX</div>
            <div>ElementUI</div>
            <div>Axios</div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>

  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  }
}
</script>
