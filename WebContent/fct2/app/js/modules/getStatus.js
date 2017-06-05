import axios from 'axios'

export default () => {
  axios.get('rest/cmd/status').then((response) => {
    const status = response.data.status
    if (status === 'stopped') {
      document.querySelector('#state').innerHTML = 'Stopped'
      document.querySelector('#spinner').classList.remove('fa-spin')
    } else {
      const user = response.data.user
      document.querySelector('#state').innerHTML = `Running(${user})`
    }
  })
}
