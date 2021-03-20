<template>
    <div class="feedback-table-area">
    <table class="feedback-table" aria-label="Feedback table">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Category</th>
            <th>Text</th>
        </tr>
        </thead>
        <tbody>
          <tr v-for="(feedback, index) in feedbacks" :key="feedback.id">
            <td>{{index+1}}</td>
            <td>{{feedback.name}}</td>
            <td>{{feedback.email}}</td>
            <td>{{feedback.category.join()}}</td>
            <td>{{feedback.text}}</td>
          </tr>
        </tbody>
    </table>
    <button class="w-100 btn btn-lg btn-primary" @click="deleteAll">Delete All Entries</button>

</div>
</template>

<script>



export default {
    props: {
    feedbacks: {
      type: Array,
      default () {
        return []
      }
    }
  },
    methods: { 
        deleteAll: function() {
          this.$services.feedback.deleteAll().then((data) => {
        this.$emit('update-table')});
        }
    }
}
</script>

<style scoped>
.feedback-table-area, .feedback-table-area .feedback-table {
  width: 100%;
}

</style>