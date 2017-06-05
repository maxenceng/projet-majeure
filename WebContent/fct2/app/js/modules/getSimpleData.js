import axios from 'axios'

/**
 * Fonction qui récupère simplement les données de notre classe Java Measures et les insère dans notre page
 * lors de l'appui sur le bouton Refresh.
 */
export default () => {
  document.querySelector('#refreshBtn').addEventListener('click', () => {
    axios.get('rest/cmd/measures').then((response) => {
      document.querySelector('#ajaxData1').innerHTML = response.data.nbreCommande
      document.querySelector('#ajaxData2').innerHTML = response.data.distanceParcourue
      document.querySelector('#ajaxData3').innerHTML = response.data.nbreObstRencontres
      document.querySelector('#ajaxData4').innerHTML = response.data.nbreObstVisible
    })
  })
}

