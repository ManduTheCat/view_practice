export default {
  template: `
  <form action="">
    <input type="text" v-model:"id" name="id" id="id">
    <input type="password" v-model:"passwored" name="passwored" id="passwored">
    <input type="submit" value="">
  </form>
  `,
  data() {
    return {
      id: "",
      passwored: "",
    };
  },
  methdos: {},
};
