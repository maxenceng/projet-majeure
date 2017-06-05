import Chart from 'chart.js'
import axios from 'axios'


const chart1 = document.querySelector('#myChart1')
const chart2 = document.querySelector('#myChart2')
const chart3 = document.querySelector('#myChart3')
const chart4 = document.querySelector('#myChart4')

/**
 * Création des variables servant à l'insertion des données dans les chartes.
 */
const labels = []
const nbreCommande = []
const distanceParcourue = []
const nbreObstRencontres = []
const nbreObstVisible = []

/**
 * Définie les données de base de nos chartes.
 */
const data = {
  labels,
  datasets: [
    {
      fill: false,
      lineTension: 0,
      backgroundColor: 'rgba(75,192,192,0.4)',
      borderColor: 'rgba(75,192,192,1)',
      data: [],
    },
  ],
}

/**
 * Définie les options de nos chartes.
 */
const options = {
  responsive: false,
  maintainAspectRatio: false,
  legend: {
    display: false,
  },
}

/**
 * Définition du contenu des chartes avant l'insertion des nouvelles données.
 * L'écriture utilisé de notre variable est possible avec ES6.
 * (https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Op%C3%A9rateurs/Initialisateur_objet)
 */
const content = {
  type: 'line',
  data,
  options,
}

/**
 * Création des chartes avec Chart.js.
 */
const lineChart1 = new Chart(chart1, content)
const lineChart2 = new Chart(chart2, content)
const lineChart3 = new Chart(chart3, content)
const lineChart4 = new Chart(chart4, content)

let k = 0

/**
 * Fonction exporté servant à mettre à jour les données de nos chartes.
 */
export default () => {
  labels.push(k)
  k += 1
  axios.get('rest/cmd/measures').then((response) => {
    nbreCommande.push(response.data.nbreCommande)
    distanceParcourue.push(response.data.distanceParcourue)
    nbreObstRencontres.push(response.data.nbreObstRencontres)
    nbreObstVisible.push(response.data.nbreObstVisible)
    lineChart1.data.labels = labels
    lineChart1.data.datasets[0].data = nbreCommande
    lineChart1.update()
    lineChart2.data.labels = labels
    lineChart2.data.datasets[0].data = distanceParcourue
    lineChart2.update()
    lineChart3.data.labels = labels
    lineChart3.data.datasets[0].data = nbreObstRencontres
    lineChart3.update()
    lineChart4.data.labels = labels
    lineChart4.data.datasets[0].data = nbreObstVisible
    lineChart4.update()
  })
}
