<template>
<client-only>
    <div class="form-feedback" id="feedback-form">
    <form>
        <h1 class="h3 mb-3 fw-normal">Please give us feedback</h1>
        <div class="mb-3">
            <label for="inputName" class="visually-hidden">Name</label>
            <input v-model="name" type="text" id="inputName" class="form-control" placeholder="Name" required autofocus >
        </div>
        <div class="mb-3">
            <label for="inputEmail" class="visually-hidden">Email address</label>
            <input v-model="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required >
        </div>
        <div class="mb-3">
            <label for="inputFeedback" class="visually-hidden">Text</label>
            <textarea v-model="feedbackText" id="inputFeedback" class="form-control" placeholder="Text" required ></textarea>
        </div>
        <div class="mb-3">
            <label for="inputCategory" class="visually-hidden">Category</label>
            <select v-model="category" id="inputCategory" class="form-select" multiple aria-label="multiple select example" >
                <option value="1" disabled>Application</option>
                <option value="10" disabled>- Health</option>
                <option value="Patients portal">-- Patients portal</option>
                <option value="Doctors portal">-- Doctors portal</option>
                <option value="2" disabled>-- Remote visits portal</option>
                <option value="Registration">--- Registration</option>
                <option value="Virtual visit">--- Virtual visit</option>
                <option value="22" disabled>- Document management</option>
                <option value="OpenKM">-- OpenKM</option>
                <option value="Microsoft SharePoint">-- Microsoft SharePoint</option>
            </select>
        </div>

        <button class="w-100 btn btn-lg btn-primary" @click="checkForm" type="submit">Send</button>

        <p v-for="error in errors" :key="error"> {{error}} </p>
    </form>
</div>
</client-only>
</template>

<script>



export default {
    data() {
      return {
        name: '',
        email: '',
        category: [],
        feedbackText: '',
        errors: []
      }
    },
    methods: {
    create () {
        this.$services.feedback.create({
        name: this.name,
        email: this.email,
        category: this.category,
        text: this.feedbackText
    }).then((data) => {
        this.$emit('update-table')
        this.name = ""
        this.email = ""
        this.category = []
        this.feedbackText = ""
  })
    },
    checkForm:function(e) {
        this.errors = [];
        if (!this.name) {
          this.errors.push("Name required");
          }

        if (!this.email || !/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(this.email)) {
          this.errors.push("Email required");
          }
    
        if (!this.feedbackText) {
          this.errors.push("Text required");
          }

        if (this.category.length === 0) {
          this.errors.push("Category required");
          }
        
        if (this.errors.length == 0) {
            this.create();
          }
      e.preventDefault();
    }
  }
}
</script>

<style scoped>
.form-feedback {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-feedback .checkbox {
  font-weight: 400;
}
.form-feedback .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-feedback .form-control:focus {
  z-index: 2;
}
.form-feedback input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-feedback input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

p {
  text-align: center;
  color: red;
}
</style>