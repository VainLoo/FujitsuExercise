<template>
  <div class="container">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
              integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
              crossorigin="anonymous"></script>

    <feedback-table :feedbacks="feedbacks" @update-table="update"/>

    <feedback-form @update-table="update"/>


  </div>

  
</template>

<script>
import FeedbackForm from '../components/FeedbackForm.vue'
import FeedbackTable from '../components/FeedbackTable.vue'

export default {
  components: {
    FeedbackTable, 
    FeedbackForm,
  },
  data () {
    return {
      feedbacks: {
        type: Array
      }
    }
  },
  methods: {
    update: async function() {
      this.feedbacks = await this.$services.feedback.findAll()
    }
  },
  async asyncData (ctx) {
    return {
      feedbacks: await ctx.app.$services.feedback.findAll()
    }
  }
}
</script>