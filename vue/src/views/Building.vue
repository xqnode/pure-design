<template>
  <div style="margin: 10px 0">
    <el-cascader :options="options" v-model="buildingData"></el-cascader>
    <el-button type="primary" @click="search" class="ml-5">搜索</el-button>
  </div>
</template>

<script>
export default {
  name: "Building",
  data() {
    return {
      options: [],
      buildingData: null,
      houses: []
    }
  },
  created() {
    this.request.get("/building/tree").then(res => {
      this.options = res.data
    })
  },
  methods: {
    search() {
      console.log(this.buildingData)

      if (!this.buildingData) {
        return
      }
      const building = this.buildingData[0]
      const unit = this.buildingData[1]
      const house = this.buildingData[2]
      this.request.get("/building/house", {
        params: {
          building: building,
          unit: unit,
          house: house
        }
      }).then(res => {
        this.houses = res.data
      })
    }
  }
}
</script>

<style scoped>

</style>