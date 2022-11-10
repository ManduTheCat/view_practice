<template>
  <div>
    <input type="number" v-model="lawDCd" name="" id="" />
    <input type="number" v-model="dealYmd" name="" id="" />
    <button @click="getAptList">아파트 목록 얻기</button>
    <table>
      <colgroup>
        <col style="width: 10%" />
        <col style="width: 30%" />
        <col style="width: 20%" />
        <col style="width: 10%" />
        <col style="width: 30%" />
      </colgroup>
      <tr>
        <td>일련번호</td>
        <td>아파트 번호</td>
        <td>법정동</td>
        <td>층</td>
        <td>매매가격</td>
      </tr>
      <tbody>
        <apt-list-item
          v-for="(apt, index) in apts"
          :key="index"
          :apt="apt"></apt-list-item>
      </tbody>
    </table>
    <router-view></router-view>
  </div>
</template>

<script>
import axios from "axios";
import AptListItem from "./AptListItem.vue";
export default {
  name: "AptList",
  methods: {
    getAptList() {
      //const serviceKey =
      "CHlcqjmKPiRo2x2GZREIKC48O9V3%2B%2Fobcci4fPmvrm5kWYIJYgxshGO1SIs2pae0%2FtFKFLsxREmIUQafkRCr4g%3D%3D";
      //const url = `http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=${serviceKey}&pageNo=1&numOfRows=10&LAWD_CD=${this.lawDCd}&DEAL_YMD=${this.dealYmd}`;
      const url = `http://localhost:9999/vue/map/aptlist/${this.lawDCd}/${this.dealYmd}`;
      //console.log(serviceKey);
      //console.log(url);
      axios.get(url).then((res) => {
        console.log(res);
        this.apts = res.data.response.body.items.item;
      });
    },
  },
  data() {
    return {
      lawDCd: "11110",
      dealYmd: "201512",
      apts: [],
    };
  },

  created() {},
  components: {
    AptListItem,
  },
};
</script>
<style scoped>
td {
  font-weight: bolder;
}
</style>
