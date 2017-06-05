import axios from 'axios'
import chartes from './modules/chartes'
import { move, drawEnv } from './modules/carte'
import getStatus from './modules/getStatus'
import getSimpleData from './modules/getSimpleData'

drawEnv()
getStatus()
setInterval(chartes, 1000)
getSimpleData()

document.querySelector('#fs').addEventListener('click', () => {
  if (!document.querySelector('#fs').checked) {
    document.querySelector('#chartes').classList.add('hidden')
    document.querySelector('#simple').classList.remove('hidden')
  } else {
    document.querySelector('#chartes').classList.remove('hidden')
    document.querySelector('#simple').classList.add('hidden')
  }
})


document.querySelector('#btnUp').addEventListener('click', () => {
  axios.post('rest/cmd/UP', {}).then((response) => {
    if (response.data === 'OK') {
      move('UP')
    }
  })
})

document.querySelector('#btnLeft').addEventListener('click', () => {
  axios.post('rest/cmd/LEFT', {}).then((response) => {
    if (response.data === 'OK') {
      move('LEFT')
    }
  })
})

document.querySelector('#btnRight').addEventListener('click', () => {
  axios.post('rest/cmd/RIGHT', {}).then((response) => {
    if (response.data === 'OK') {
      move('RIGHT')
    }
  })
})

document.querySelector('#btnDown').addEventListener('click', () => {
  axios.post('rest/cmd/DOWN', {}).then((response) => {
    if (response.data === 'OK') {
      move('DOWN')
    }
  })
})
