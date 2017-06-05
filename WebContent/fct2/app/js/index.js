import axios from 'axios'
// eslint-disable-next-line no-unused-vars
import sass from '../sass/index.sass'
import chartes from './modules/chartes'
import { move, drawEnv } from './modules/carte'

setInterval(chartes, 5000)

// PARTIE CARTE

drawEnv()

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
