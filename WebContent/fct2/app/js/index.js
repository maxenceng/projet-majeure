import axios from 'axios'
import chartes from './modules/chartes'
import { move, drawEnv } from './modules/carte'
import getStatus from './modules/getStatus'
import getSimpleData from './modules/getSimpleData'

/**
 * Appel aux fonctions nécessaires au bon fonctionnement de notre page :
 * - drawEnv pour l'affichage de l'environnement sur le canvas principal;
 * - getStatus pour l'affichage de l'état du robot et l'utilisateur en cours s'il y en a un;
 * -
 */
drawEnv()
getStatus()
setInterval(chartes, 5000)
getSimpleData()

/**
 * Echange l'affichage des chartes et l'affichage des données en brut
 * suivant l'état du switch.
 */
document.querySelector('#fs').addEventListener('click', () => {
  if (!document.querySelector('#fs').checked) {
    document.querySelector('#chartes').classList.add('hidden')
    document.querySelector('#simple').classList.remove('hidden')
  } else {
    document.querySelector('#chartes').classList.remove('hidden')
    document.querySelector('#simple').classList.add('hidden')
  }
})

/**
 * Effectue un mouvement vers le haut du robot si possible
 */
document.querySelector('#btnUp').addEventListener('click', () => {
  axios.post('rest/cmd/UP', {}).then((response) => {
    if (response.data === 'OK') {
      move('UP')
    }
  })
})

/**
 * Effectue un mouvement vers la gauche du robot si possible
 */
document.querySelector('#btnLeft').addEventListener('click', () => {
  axios.post('rest/cmd/LEFT', {}).then((response) => {
    if (response.data === 'OK') {
      move('LEFT')
    }
  })
})

/**
 * Effectue un mouvement vers la droite du robot si possible
 */
document.querySelector('#btnRight').addEventListener('click', () => {
  axios.post('rest/cmd/RIGHT', {}).then((response) => {
    if (response.data === 'OK') {
      move('RIGHT')
    }
  })
})

/**
 * Effectue un mouvement vers le bas du robot si possible
 */
document.querySelector('#btnDown').addEventListener('click', () => {
  axios.post('rest/cmd/DOWN', {}).then((response) => {
    if (response.data === 'OK') {
      move('DOWN')
    }
  })
})
