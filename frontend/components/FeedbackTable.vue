<template>
    <div class="feedback-table-area">
    <table class="feedback-table" aria-label="Feedback table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Category</th>
            <th scope="col">Text</th>
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
    <button @click="deleteAll">Delete All Entries</button>

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
        create() {
            this.$services.feedback.create(feedback).then((data) => {
            this.$emit('create', data)})
        },
        deleteAll: function() {
          this.feedbacks.forEach(feedback => this.$services.feedback.deleteItem(feedback.id))
          return 0
        }
    },
}
</script>

<style scoped>
.feedback-table-area, .feedback-table-area .feedback-table {
  width: 100%;
}
</style>