import Feedback from '~/assets/data/Feedback.class'

export default class FeedbackApi {
  constructor ($axios) {
    this.axios = $axios
  }

  findAll () {
    return this.axios({
      method: 'get',
      url: 'feedback',
      withCredentials: true
    }).then((response) => {
      const feedbacks = []
      response.data.forEach((feedback) => {
        feedbacks.push(new Feedback(feedback.id, feedback.name, feedback.email, feedback.category, feedback.text))
      })
      return feedbacks
    })
  }

  create (feedback) {
    return this.axios({
      method: 'post',
      url: 'feedback',
      data: {
        id: feedback.id,
        name: feedback.name,
        email: feedback.email,
        category: feedback.category,
        text: feedback.text
      },
      withCredentials: true
    }).then((response) => {
      return response.data
    })
  }

  complete (feedback) {
    return this.axios({
      method: 'put',
      url: 'feedback/' + feedback.id,
      data: {
        id: feedback.id,
        name: feedback.name,
        email: feedback.email,
        category: feedback.category,
        text: feedback.text
      },
      withCredentials: true
    }).then((response) => {
      return response.data
    })
  }

  deleteItem (id) {
    return this.axios({
      method: 'delete',
      url: 'feedback/' + id,
      withCredentials: true
    })
  }

  deleteAll () {
    return this.axios({
      method: 'delete',
      url: 'feedback',
      withCredentials: true
    })
  }
}