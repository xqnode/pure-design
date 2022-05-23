<template>
  <div style="margin: 10px 0">

    <div style="margin-bottom: 20px">
      <el-date-picker
          size="medium"
          v-model="datetime"
          type="datetimerange"
          format="yyyy-MM-dd HH:mm:ss"
          value-format="yyyy-MM-dd HH:mm:ss"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期">
      </el-date-picker>
      <el-button size="medium" type="primary" @click="load" class="ml-5">搜索</el-button>
    </div>

    <el-table :data="tableData" border stripe>
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="文章标题"></el-table-column>
      <el-table-column prop="user" label="发布人"></el-table-column>
      <el-table-column prop="time" label="发布时间"></el-table-column>
    </el-table>

  </div>
</template>

<script>
export default {
  name: "TimeSearch",
  data() {
    return {
      datetime: null,
      tableData: []
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      console.log(this.datetime)
      // if (!this.datetime) {
      //   return
      // }
      let start = ""
      let end = ""
      if (this.datetime && this.datetime.length >= 2) {
         start = this.datetime[0]
         end = this.datetime[1]
      }
      this.request.get("/article", {
        params: {
          start: start,
          end: end
        }
      }).then(res => {
        this.tableData = res.data
      })
    }
  }
}
</script>

<style scoped>

</style>