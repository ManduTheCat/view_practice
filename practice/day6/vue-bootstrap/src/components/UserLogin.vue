<template>
  <div class="w-100 p-3 mb-1 bg-secondary d-flex justify-content-center">
    <div class="w-50 p-3 mb-1 bg-secondary text-light">
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <b-form-group
          id="input-group-1"
          label="아이디"
          label-for="input-1"
          description="We'll never share your email with anyone else."
        >
          <b-form-input
            id="input-1"
            v-model="form.userId"
            type="text"
            placeholder="user Id"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="password:" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="form.password"
            placeholder="password"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">제출</b-button>
      </b-form>
      <b-card class="mt-3" header="Form Data Result">
        <pre class="m-0">{{ form }}</pre>
      </b-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        userId: "",
        password: "",
      },
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.userId = "";
      this.form.password = "";
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>
