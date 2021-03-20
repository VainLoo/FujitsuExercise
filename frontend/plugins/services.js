import FeedbackService from '~/assets/service/FeedbackService'

export default (ctx, inject) => {
  const services = {
    feedback: new FeedbackService(ctx.$axios)
  }

  inject('services', services)
}