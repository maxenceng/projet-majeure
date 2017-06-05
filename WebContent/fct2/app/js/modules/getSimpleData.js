import axios from 'axios'

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

